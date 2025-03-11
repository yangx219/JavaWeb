package com.javaweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.javaweb.mapper.EmpExprMapper;
import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.*;
import com.javaweb.service.EmpLogService;
import com.javaweb.service.EmpService;
import com.javaweb.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

/************************Requêtes paginées de la manière originale**************************************/
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. appel interface mapper pour interroger la nombre d'enregistrements
        Long total = empMapper.count();
        //2. appel interface mapper pour interroger le result list
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        //3. encapsuler le résultat pageResult
        return new PageResult<>(total, rows);
    }*/

    /***
     * PageHeler Requêtes paginées
     * @return
     * attention!:
     *          1. pas de ; à la fin de SQL requête
     *          2. PageHelper traite que la première instruction de requête suivante
     */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize,
                                String name, Integer gender,
                                LocalDate begin, LocalDate end) {
        //1. Définir les paramètres de pagination (PageHelper)
        PageHelper.startPage(page, pageSize);

        //2. Interroger
        List<Emp> empList = empMapper.list(name, gender, begin, end);

        //3. encapsuler le résultat pageResult
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }*/

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1. Définir les paramètres de pagination (PageHelper)
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. Interroger
        List<Emp> empList = empMapper.list(empQueryParam);

        //3. encapsuler le résultat pageResult
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    /**
     * Ajouter un nouvel employé
     * @param emp
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) throws Exception {
        //cmd+opt+t-->try
        try {
            //1. completer les infos basic
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            //2. enregistrer les infos basic
            empMapper.insert(emp);

            int i = 1/0;

            //3. enregistrer les infos d'expériences professionnelles - en lot
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(empExpr -> empExpr.setEmpId(empId));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //4. enregistrer des operations logs
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"nouvel employé:"+emp);
            empLogService.insertLog(empLog);

        }



    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        //1. Supprimer les infos basic de emp
        empMapper.deleteByIds(ids);

        //2. Supprimer les expr pro de emp
        empExprMapper.deleteByEmpIds(ids);


    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        //1. modifier les infos de base selon ID
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //2. modifier les expr pro selon ID
        //2.1 supprimer d'abord
    empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //2.2 et puis ajouter le nouvel expr pro
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public LoginInfo login(Emp emp) {
        //1. Appeler le mapper selon username et mot de passe
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        /* 2. Vérifier si cet employé existe,
           et s'il existe, assembler les informations de connexion réussie*/
        if (e != null) {
            log.info("Connection success, userInfo:{}", e);
            //Générer JWT token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            System.out.println(jwt);

            return new LoginInfo(e.getId(),e.getUsername(),e.getName(),jwt);

        }

        //3.si exist pas
        return null;
    }
}

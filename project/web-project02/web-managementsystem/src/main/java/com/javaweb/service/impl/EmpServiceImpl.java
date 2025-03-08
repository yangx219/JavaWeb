package com.javaweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.Emp;
import com.javaweb.pojo.PageResult;
import com.javaweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

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
     * @param page
     * @param pageSize
     * @return
     * attention!:
     *          1. pas de ; à la fin de SQL requête
     *          2. PageHelper traite que la première instruction de requête suivante
     */
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. Définir les paramètres de pagination (PageHelper)
        PageHelper.startPage(page, pageSize);

        //2. Interroger
        List<Emp> empList = empMapper.list();

        //3. encapsuler le résultat pageResult
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}

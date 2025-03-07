package com.javaweb.service.impl;

import com.javaweb.mapper.DeptMapper;
import com.javaweb.pojo.Dept;
import com.javaweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /**
     * Supprimer le department par id
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * Ajouter le department
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        //1. on a reçu que name, donc il faut completer createTime, updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //2. appeler Mapper pour insérer les infos
        deptMapper.insert(dept);

    }
}
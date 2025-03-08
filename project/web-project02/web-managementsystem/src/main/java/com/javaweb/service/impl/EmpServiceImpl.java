package com.javaweb.service.impl;

import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.Emp;
import com.javaweb.pojo.PageResult;
import com.javaweb.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1. appel interface mapper pour interroger la nombre d'enregistrements
        Long total = empMapper.count();
        //2. appel interface mapper pour interroger le result list
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        //3. encapsuler le résultat pageResult
        return new PageResult<>(total, rows);
    }
}

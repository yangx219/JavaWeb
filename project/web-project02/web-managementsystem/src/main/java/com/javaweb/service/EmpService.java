package com.javaweb.service;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.PageResult;
import org.springframework.stereotype.Service;

@Service//Constructeur
public interface EmpService {
    PageResult<Emp> page(Integer page, Integer pageSize);
}

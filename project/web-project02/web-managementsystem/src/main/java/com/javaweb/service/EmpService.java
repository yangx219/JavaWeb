package com.javaweb.service;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.EmpQueryParam;
import com.javaweb.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service//Constructeur
public interface EmpService {
    /*PageResult<Emp> page(Integer page, Integer pageSize,
                         String name, Integer gender,
                         LocalDate begin, LocalDate end);*/

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * Ajouter un nouvel employé
     * @param emp
     */
    void save(Emp emp);
}

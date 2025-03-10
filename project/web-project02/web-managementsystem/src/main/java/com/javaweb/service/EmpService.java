package com.javaweb.service;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.EmpQueryParam;
import com.javaweb.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    void save(Emp emp) throws Exception;

    /**
     * Suppression en masse des informations des employés
     * Batch deletion of employee information
     * @param ids
     */
    void delete(List<Integer> ids);
}

package com.javaweb.controller;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.EmpQueryParam;
import com.javaweb.pojo.PageResult;
import com.javaweb.pojo.Result;
import com.javaweb.service.EmpService;
import com.javaweb.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Gestion des employés
 */
@RequestMapping ("/emps")
@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    /**
     * Requêtes paginées
     */
    /*@GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("Requêtes paginées : {}, {},{},{},{}", page, pageSize, name, gender, begin, end);
        PageResult<Emp> pageResult = empService.page(page,pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }*/
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("Requêtes paginées : {}, {},{},{},{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * Ajouter un nouvel employé
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception {
        log.info("Ajouter un nouvel employé: {}",emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * Supprimer les employés -- Arrays
     * @param ids
     * @return
     */
    /*@DeleteMapping
    public Result delete(Integer[] ids){
        log.info("Supprimer les employés : {}", Arrays.toString(ids));
        return Result.success();
    }*/



    /**
     * Supprimer les employés -- List
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("Supprimer les employés : {}", ids);
        empService.delete(ids);
        return Result.success();
    }

}


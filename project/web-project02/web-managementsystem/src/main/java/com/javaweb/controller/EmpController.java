package com.javaweb.controller;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.PageResult;
import com.javaweb.pojo.Result;
import com.javaweb.service.EmpService;
import com.javaweb.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer pageSize) {
        log.info("Requêtes paginées : {}, {}", page, pageSize);
        PageResult<Emp> pageResult = empService.page(page,pageSize);
        return Result.success(pageResult);
    }
}

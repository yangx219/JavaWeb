package com.javaweb.controller;

import com.javaweb.pojo.Dept;
import com.javaweb.pojo.Result;
import com.javaweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //Rechercher tous les départements
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    //Supprimer un département
    @DeleteMapping
    public Result delete(Integer id)  {
        deptService.delete(id);
        return Result.success();
    }

    //Ajouter un département
    @PostMapping
    public Result save(@RequestBody Dept dept){
        deptService.save(dept);
        return Result.success();
    }

    //Rechercher un département par ID
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept =  deptService.getById(id);
        return Result.success(dept);
    }

    //Mettre à jour un département
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}

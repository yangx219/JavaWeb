package com.javaweb.controller;

import com.javaweb.pojo.Dept;
import com.javaweb.pojo.Result;
import com.javaweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Department management controller
 */
@RestController//body json
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * Interroger la liste des départements
     * Query the list of departments
     * 查询部门列表
     */
    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

}

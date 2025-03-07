package com.javaweb.controller;

import com.javaweb.pojo.Dept;
import com.javaweb.pojo.Result;
import com.javaweb.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Supprimer la department par ID
     * method 1 : HttpServletRequest request
     */
    /*@DeleteMapping("/depts")
    public Result delete(HttpServletRequest request) {

        String idStr = request.getParameter("id");

        int id = Integer.parseInt(idStr);

        System.out.println("Supprimer la department par ID: " + id);
        return Result.success();

    }
*/
    /**
     * Supprimer la department par ID
     * method 2 : @RequestParam
     * si la paramètre est pas obligatoire :
     * : @RequestParam(value = "id", required = false)
     */
   /* @DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer deptId) {
        System.out.println("Supprimer la department par ID: " + deptId);
        return Result.success();

    }*/

    /**
     * Supprimer la department par ID
     * method 3 : omettre @RequestParam
     * mais le nome est pareil
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println("Supprimer la department par ID: " + id);
        return Result.success();

    }
}

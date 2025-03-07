package com.javaweb.controller;

import com.javaweb.pojo.Dept;
import com.javaweb.pojo.Result;
import com.javaweb.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Department management controller
 */
@Slf4j
@RequestMapping("/depts")
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
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * Supprimer le department par ID
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
     * Supprimer le department par ID
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
     * Supprimer le department par ID
     * method 3 : omettre @RequestParam
     * mais le nome est pareil
     */
    @DeleteMapping
    public Result delete(Integer id) {
//        System.out.println("Supprimer la department par ID: " + id);
        log.info("Supprimer la department par id:{}", id);
        deptService.deleteById(id);
        return Result.success();

    }


    /**
     * Ajouter le department
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("Ajouter le department : " + dept);
        log.info("Ajouter le department :{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * interroger le department par id
     */
    /*@GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId) {
        System.out.println("interroger le department par id : " +deptId);
        return Result.success();

    }*/

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
//        System.out.println("Interroger le department par id : " +id);
        log.info("Interroger le department par id:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);

    }

    /**
     * Modifier le department
     * @param dept
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("Updater le department : " + dept);
        deptService.update(dept);
        return Result.success();
    }
}

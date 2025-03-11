package com.javaweb.controller;


import com.javaweb.pojo.Emp;
import com.javaweb.pojo.LoginInfo;
import com.javaweb.pojo.Result;
import com.javaweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login Controller
 */
@Slf4j//log
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("LoginController.login emp:{}", emp);
        LoginInfo info = empService.login(emp);
        if (info != null) {
            return Result.success(info);
        }
        /**
         * Nom d'utilisateur ou mot de passe incorrect.
         * Username or password incorrect.
         */
        return Result.error("Nom d'utilisateur ou mot de passe incorrect");

    }
}

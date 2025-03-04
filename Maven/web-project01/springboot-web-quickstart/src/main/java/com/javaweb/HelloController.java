package com.javaweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示当前类是一个请求处理类
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(String name){
        System.out.println("name : " +name);
        return "Hello" + name + "~";

    }

}

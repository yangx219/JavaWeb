package com.itheima;

import com.google.gson.Gson;
import com.itheima.controller.DeptController;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootWebTests {
    @Autowired
    private ApplicationContext applicationContext; //IOC容器对象
    @Autowired
    private Gson gson;

    //bean的作用域
    @Test
    public void testScope(){
        for (int i = 0; i < 10; i++) {
            DeptController deptController = applicationContext.getBean(DeptController.class);
            System.out.println(deptController);
        }
    }

    @Test
    public void testJson(){
        System.out.println(gson.toJson(Result.success("Hello Gson")));
    }



}

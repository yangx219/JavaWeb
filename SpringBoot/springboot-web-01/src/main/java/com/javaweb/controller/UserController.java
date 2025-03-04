package com.javaweb.controller;

import cn.hutool.core.io.IoUtil;
import com.javaweb.pojo.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * user info controller
 */
@RestController//@ResponseBody --->json
public class UserController {
    @RequestMapping("/list")
    public List<User> list() throws IOException {

        //1.load and read the user.txt, get user info
//        InputStream in = this.getClass().getResourceAsStream("user.txt");
        InputStream in = new ClassPathResource("user.txt").getInputStream();
//        InputStream in = new FileInputStream(new File("src/main/resources/user.txt"));

        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());


        //2. Parse user information and encapsulate it as a user object --> list
        List<User> userList = lines.stream().map(line->{
            //read the data from file
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.valueOf(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();
        


        //3.return data to the front-end
        return userList;
    }
}

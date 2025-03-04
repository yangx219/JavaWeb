package com.javaweb.service.impl;

import com.javaweb.dao.UserDao;
import com.javaweb.pojo.User;
import com.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Component//Laissez la classe actuelle au conteneur IOC pour la gestion
//@Primary//Augmenter la priorité de bean  提高bean的优先级
@Service
public class UserServiceImpl2 implements UserService {
    /**
     * Lorsque l’application s’exécute,
     * elle interroge automatiquement l’objet bean de ce type
     * et attribue des valeurs aux variables membres
     *app运行时，会自动查询该类型的bean对象，并赋值给改成员变量
     */
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() throws IOException {

        //1.applel dao, get user data
        List<String> lines = userDao.findAll();


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
            return new User(id + 200, username, password, name, age, updateTime);
        }).toList();
        return userList;
    }
}

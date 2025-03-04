package com.javaweb.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.javaweb.dao.UserDao;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//@Component//Laissez la classe actuelle au conteneur IOC pour la gestion
@Repository//("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findAll() throws IOException {
        //1.load and read the user.txt, get user info
        InputStream in = new ClassPathResource("user.txt").getInputStream();
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
        return lines;

    }



}

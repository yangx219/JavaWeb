package com.javaweb;

import com.javaweb.mapper.UserMapper;
import com.javaweb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void tetFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);

    }

}

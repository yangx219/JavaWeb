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
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);

    }

    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(5);
        System.out.println(i + " rows has been deleted");

    }

    @Test
    public void testInsert() {
        User user = new User(null,"sara","666777","Sara",18);
        userMapper.insert(user);

    }

    @Test
    public void testUpdate() {
        User user = new User(1,"alice","777888","Alice",18);
        userMapper.update(user);

    }

    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("sara","666777");

        System.out.println(user);
    }

}

package com.javaweb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testGetAge() {
        Integer age = new UserService().getAge("110002200105091218");
        System.out.println(age);

    }

    /**
     * assert
     */
    @Test
    public void testGenderWithAssert(){
        UserService userService = new UserService();
        String gender = userService.getGender("110002200505091211");
        Assertions.assertEquals("男",gender);
    }
    @Test
    public void testGenderWithAssert2(){
        UserService userService = new UserService();
        String gender = userService.getGender("110002200505091211");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            userService.getGender("null");
        });
    }
}

package com.javaweb;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testGetAge() {
        Integer age = new UserService().getAge("110002200505091218");
        System.out.println(age);

    }
}

package com.javaweb;

import lombok.Data;

@Data
public class LombokTest {
    private String name;
    public static void main(String[] args) {
        LombokTest test = new LombokTest();
        test.setName("Hello Lombok");
        System.out.println(test.getName());  // 应该输出 "Hello Lombok"
    }
}

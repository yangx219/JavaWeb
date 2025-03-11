package com.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//Activation du support des composants Servlet dans Spring Boot（Enabled Spring Boot support for Servlet components）
@SpringBootApplication
public class WebManagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagementsystemApplication.class, args);
    }

}

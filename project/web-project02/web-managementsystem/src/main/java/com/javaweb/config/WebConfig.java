package com.javaweb.config;

import com.javaweb.interceptor.DemoInterceptor;
import com.javaweb.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * configuration class
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*@Autowired
    private DemoInterceptor demoInterceptor;*/
    /*@Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")//intercepter tous les requetes
                .excludePathPatterns("/login");
    }*/
}

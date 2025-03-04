package com.javaweb;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        //1. get the request method
        String method = request.getMethod();
        System.out.println("request method:"+method);

        //2. get address url
        String url = request.getRequestURL().toString();
        System.out.println("request url:"+url);
        String uri = request.getRequestURI();
        System.out.println("request uri:"+uri);

        //3. get request protocol
        String protocol = request.getProtocol();
        System.out.println("request protocol:"+protocol);

        //4. get request parameter - name ,age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("request name:"+name + ", age:"+age);

        //5. get request header -Accept
        String accept = request.getHeader("accept");
        System.out.println("request accept:"+accept);

        return "success";


    }
}

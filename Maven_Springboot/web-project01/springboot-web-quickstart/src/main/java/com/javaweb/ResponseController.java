package com.javaweb;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    /*
    * method 1: HttpServletResponse set the response data
    *
    * */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1. set the response code
        response.setStatus(401);

        //response header
        response.setHeader("name", "yangxue");

        //response body
        response.getWriter().write("<h1>Hello response</h1>");

    }



    /*
     * method 2: ResponseEntity - Spring support
     *
     * */
    @RequestMapping("/response2")
    public ResponseEntity<String> responseJson(HttpServletResponse response) {
        return ResponseEntity
                .status(401)
                .header("name","yangxue")
                .body("<h1>Hello response</h1>");
    }
}

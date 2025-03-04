package com.javaweb.service;

import com.javaweb.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    /**
     * find all the user data
     * @return
     */
    public List<User> findAll() throws IOException;
}

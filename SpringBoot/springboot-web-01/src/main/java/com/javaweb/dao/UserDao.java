package com.javaweb.dao;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    /**
     * get the user data
     */
    public List<String> findAll() throws IOException;
}

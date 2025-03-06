package com.javaweb.service;

import com.javaweb.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * Interroger tous les départements
     * 查询所有部门
     */
    public List<Dept> findAll();
}

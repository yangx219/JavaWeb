package com.javaweb.mapper;

import com.javaweb.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * Interroger tous les départements
     * 查询所有部门
     */
    //methode 1:
    /*@Results({
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })*/

    //method 2: alias
    //@Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc")
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    public List<Dept> findAll();
}

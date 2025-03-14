package com.javaweb.mapper;

import com.javaweb.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    //Rechercher tous les départements
    @Select("select * from dept")
    List<Dept> list();

    //Supprimer un département
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    //Ajouter un département
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void save(Dept dept);

    //Rechercher un département par ID
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    //Mettre à jour un département
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}




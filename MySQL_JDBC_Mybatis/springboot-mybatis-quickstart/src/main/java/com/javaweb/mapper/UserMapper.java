package com.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.javaweb.pojo.*;

import java.util.List;

/**
 * @Mapper注解：表示是mybatis中的Mapper接口
 * 程序运行时，框架会自动生成接口的实现类对象(代理对象)，
 * 并给交Spring的IOC容器管理 --bean
 * Annotation Mapper : indique qu’il s’agit de l’interface Mapper dans mybatis
 * Lorsque le programme s’exécute,
 * le framework génère automatiquement l’objet de classe d’implémentation
 * (objet proxy) de l’interface et le soumet au conteneur IOC de Spring
 * pour la gestion
 */
@Mapper
public interface UserMapper {
    //@Select("select * from user")
    public List<User> findAll();

    @Select("delete from user where id = #{id}")
    public Integer deleteById(Integer id);

    @Select("insert into user(username,password,name,age) values (#{username},#{password},#{name},#{age})")
    public void insert(User user);


    @Select("update user set username = #{username},password = #{password},name = #{name}, age = #{age} where id = #{id}")
    public void update(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}

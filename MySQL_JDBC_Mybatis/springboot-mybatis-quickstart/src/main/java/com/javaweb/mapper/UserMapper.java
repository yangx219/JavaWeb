package com.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
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
    @Select("select * from user")
    public List<User> findAll();
}

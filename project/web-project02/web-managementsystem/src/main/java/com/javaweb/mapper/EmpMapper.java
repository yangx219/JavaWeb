package com.javaweb.mapper;

import com.javaweb.pojo.Emp;
import com.javaweb.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Infos de employés
 */
@Mapper
public interface EmpMapper {
    /*************************Requêtes paginées de la manière originale*************************************/
    /**
     * Interroger le nombre total d’enregistrements
     */
   /* @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    public Long count();

    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start,Integer pageSize);*/

    /*@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc")*/
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * Ajouter les infos basic pour un nouvel employé
     * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * Suppression en masse des informations de base des employés selon l’ID
     * Batch deletion of employees’ basic information based on ID
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * Rechercher les informations et les expériences des employés selon l’ID
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * Modifier un employé selon ID
     * Edit employee
     * @param emp
     */
    void updateById(Emp emp);

    /**
     * Compter le nombre d’employés dans le poste
     * @return
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();


    /**
     *Rechercher les informations de l'employé en fonction du nom d'utilisateur et du mot de passe.
     *Query employee information based on username and password.
     * @param emp
     * @return
     */
    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}

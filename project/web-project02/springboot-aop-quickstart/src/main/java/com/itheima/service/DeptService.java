package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * Rechercher tous les départements
     * @return
     */
    List<Dept> list();

    /**
     * Supprimer un département
     * @param id
     */
    void delete(Integer id);

    /**
     * Ajouter un département
     * @param dept
     */
    void save(Dept dept);

    /**
     * Rechercher un département par ID
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * Mettre à jour un département
     * @param dept
     */
    void update(Dept dept);
}

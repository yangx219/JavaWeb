package com.javaweb.mapper;

import com.javaweb.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Expérience de travail des employés
 */
@Mapper
public interface EmpExprMapper {
    /**
     * Enregistrer en lot les informations sur l'expérience professionnelle des employés
     * Batch save employees' work experience information
     * @param exprList
     */

    void insertBatch(List<EmpExpr> exprList);

    /**
     * Suppression en masse de l’expérience professionnelle des employés en fonction de leur ID
     * Batch deletion of employees’ work experience based on their ID
     * @param ids
     */
    void deleteByEmpIds(List<Integer> empIds);
}

package com.javaweb.service;

import com.javaweb.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * Compter le nombre d'employés par poste
     */
    JobOption getEmpJobData();

    /**
     * Statistiques du nombre d'employés par sexe
     * Statistics on the number of employees by gender
     * @return
     */
    List<Map<String, Object>> getEmpGenderData();
}

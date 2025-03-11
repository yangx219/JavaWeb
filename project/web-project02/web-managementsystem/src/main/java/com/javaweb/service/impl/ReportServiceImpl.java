package com.javaweb.service.impl;

import com.javaweb.mapper.EmpMapper;
import com.javaweb.pojo.JobOption;
import com.javaweb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * Compter le nombre d'employés dans le poste
     */
    @Override
    public JobOption getEmpJobData() {
        //1. appeler l'interface de Mapper, obtenir les data
        //map: jobName=Recherche académique, num=1
        List<Map<String,Object>> list = empMapper.countEmpJobData();

        //2. encapsuler le résultat, return
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("jobName")).toList();
        List<Object> dataList =list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);



    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}

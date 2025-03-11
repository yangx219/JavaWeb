package com.javaweb.controller;

import com.javaweb.pojo.JobOption;
import com.javaweb.pojo.Result;
import com.javaweb.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * Compter le nombre d'employés par poste
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("Compter le nombre d'employés dans le poste");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);

    }

    /**
     * Statistiques du nombre d'employés par sexe
     * Statistics on the number of employees by gender
     * @return
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("Compter le nombre ");
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
}

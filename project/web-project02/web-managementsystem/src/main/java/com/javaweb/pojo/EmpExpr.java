package com.javaweb.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * Expérience professionnelle.
 */
@Data
public class EmpExpr {
    private Integer id; //ID expr
    private Integer empId;
    private LocalDate begin; //date de début
    private LocalDate end; //Date de fin
    private String company;
    private String job;
}
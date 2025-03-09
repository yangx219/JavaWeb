package com.javaweb.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender; //1 : Homme, 2 : Femme
    private String phone;
    private Integer job; // Poste, 1 : Responsable de classe, 2 : Enseignant, 3 : Responsable des affaires étudiantes, 4 : Responsable de la recherche pédagogique, 5 : Conseiller
    private Integer salary; // Salaire
    private String image; // Photo de profil
    private LocalDate entryDate; // Date d’entrée
    private Integer deptId; // ID du département associé
    private LocalDateTime createTime; // Date de création
    private LocalDateTime updateTime; // Date de mise à jour

    private String deptName;

    //Encapsulation des informations sur l'expérience professionnelle（Encapsulation of work experience information）
    private List<EmpExpr> exprList;
}

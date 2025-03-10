package com.javaweb.service;

import com.javaweb.pojo.EmpLog;

public interface EmpLogService {
    //enregistrer des logs quand inserter un nouvel employé
    public void insertLog(EmpLog empLog);
}

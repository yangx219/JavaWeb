package com.javaweb.service.impl;

import com.javaweb.mapper.EmpLogMapper;
import com.javaweb.pojo.EmpLog;
import com.javaweb.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    /*new a transaction:
    no matter the other transaction run successfully or not,
    this new transaction can run*/
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
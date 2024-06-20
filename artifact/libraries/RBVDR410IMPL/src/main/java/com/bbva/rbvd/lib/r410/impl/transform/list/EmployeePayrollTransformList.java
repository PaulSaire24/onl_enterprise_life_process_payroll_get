package com.bbva.rbvd.lib.r410.impl.transform.list;


import com.bbva.rbvd.dto.py.payroll.PayrollDTO;
import com.bbva.rbvd.lib.r410.impl.transform.bean.EmployeePayrollBean;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeePayrollTransformList {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmployeePayrollTransformList.class);

    public List<PayrollDTO> transformListMapToListPayrollDTO(List<Map<String, Object>> employeePayroll){

        LOGGER.info("[***] EmployeePayrollTransformList transformListMapToListPayrollDTO employeePayroll - {} ", employeePayroll);
        if(CollectionUtils.isEmpty(employeePayroll)){
            return new ArrayList<>();
        }
        return employeePayroll.stream().map(EmployeePayrollBean::mapTransformPayrollDTO).collect(Collectors.toList());

    }



}

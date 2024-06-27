package com.bbva.rbvd.lib.r410.business;

import com.bbva.pisd.lib.r404.PISDR404;
import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.transform.MappeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PayrollBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollBusiness.class);
    public static void getObsPayroll(EmployeePayrollResponseDTO response,PISDR404 pisdr404) {
        List<PayrollEmployeeDTO> listPayroll = response.getPayroll();
        LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll listPayroll -> {}",listPayroll);
        List<String> employeeIds = listPayroll.stream().map(PayrollEmployeeDTO::getEmployeeId).collect(Collectors.toList());
        LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll employeeIds -> {}",employeeIds);
        Map<String, Object> argumentsObs = new HashMap<>();
        argumentsObs.put("EMPLOYEE_IDS", employeeIds);
        String queryNameObs = "PISD.SELECT_PAYROLL_OBS_BY_EMPLOYEES";
        List<Map<String, Object>> resultObs = pisdr404.executeGetListASingleRow(queryNameObs,argumentsObs);
        LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll resultObs -> {}",resultObs);
        if(!CollectionUtils.isEmpty(resultObs)){
            MappeBean.mappObsPayroll(listPayroll,resultObs);
        }
        LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll listPayroll -> {}",listPayroll);
        response.setPayroll(listPayroll);
    }
}

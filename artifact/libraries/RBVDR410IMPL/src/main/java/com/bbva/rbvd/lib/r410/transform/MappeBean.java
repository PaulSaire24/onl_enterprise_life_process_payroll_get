package com.bbva.rbvd.lib.r410.transform;

import com.bbva.rbvd.dto.payroll.dto.DescriptionDTO;
import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MappeBean {

    public static EmployeePayrollResponseDTO mapResultPayroll (List<Map<String,Object>> mapList){
        EmployeePayrollResponseDTO response = new EmployeePayrollResponseDTO();
        response.setId((String) mapList.get(0).get("PAYROLL_ID"));
        DescriptionDTO status =  new DescriptionDTO();
        status.setId((String) mapList.get(0).get("PAYROLL_ID"));
        response.setStatus(status);
        List<PayrollEmployeeDTO> listPayroll = new ArrayList<>();

        for (Map<String,Object> map : mapList){
            PayrollEmployeeDTO payroll = new PayrollEmployeeDTO();
            payroll.setFirstName((String) map.get("EMPLOYEE_FIRST_NAME"));
            payroll.setLastName((String) map.get("EMPLOYEE_FIRST_LAST_NAME"));
            payroll.setBirthDate((Date) map.get("EMPLOYEE_BIRTH_DATE"));
            payroll.setGender(new DescriptionDTO());
            payroll.getGender().setId((String) map.get("EMPLOYEE_GENDER_TYPE"));
            payroll.getGender().setId((String) map.get("EMPLOYEE_GENDER_TYPE"));
        }

        return null;
    }
}

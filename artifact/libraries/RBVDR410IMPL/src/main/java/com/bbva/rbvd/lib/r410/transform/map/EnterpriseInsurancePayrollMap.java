package com.bbva.rbvd.lib.r410.transform.map;

import java.util.HashMap;
import java.util.Map;

public class EnterpriseInsurancePayrollMap {
    private EnterpriseInsurancePayrollMap() {
    }
    public static Map<String, Object> createArgumentsForGetPayrollInfo(String payrollId) {
        Map<String, Object> arguments = new HashMap<>();

        arguments.put("PAYROLL_ID", payrollId);

        return arguments;
    }
}

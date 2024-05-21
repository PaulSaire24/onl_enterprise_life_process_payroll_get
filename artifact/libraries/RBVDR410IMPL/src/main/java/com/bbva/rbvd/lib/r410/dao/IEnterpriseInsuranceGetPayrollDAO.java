package com.bbva.rbvd.lib.r410.dao;

import java.util.List;
import java.util.Map;

public interface IEnterpriseInsuranceGetPayrollDAO {
    List<Map<String,Object>> getInsurancePayroll(Map<String, Object> insurancePayrollMap);
}

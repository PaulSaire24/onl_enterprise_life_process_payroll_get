package com.bbva.rbvd.lib.r410.dao.impl;

import com.bbva.rbvd.dto.payroll.utils.RBVDErrors;
import com.bbva.rbvd.dto.payroll.utils.RBVDValidation;
import com.bbva.rbvd.lib.r410.dao.IEnterpriseInsuranceGetPayrollDAO;
import com.bbva.rbvd.lib.r414.RBVDR414;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EnterpriseInsuranceGetPayrollDAOImpl implements IEnterpriseInsuranceGetPayrollDAO {
    private final RBVDR414 rbvdR414;

    public EnterpriseInsuranceGetPayrollDAOImpl(RBVDR414 rbvdR414) {
        this.rbvdR414 = rbvdR414;
    }


    @Override
    public List<Map<String,Object>> getInsurancePayroll(Map<String, Object> insurancePayrollMap) {
        List<Map<String,Object>> saveInsurancePayroll = this.rbvdR414.executeQueryForRowListSelection("PISD.GET_EMPLOYEE_DETAILS_FROM_QUOTATION", insurancePayrollMap);
        if(saveInsurancePayroll.equals(Collections.emptyList())){
            throw RBVDValidation.build(RBVDErrors.ERROR_SAVING_T_PISD_INSURANCE_PAYROLL);
        }
        return saveInsurancePayroll;

    }
}

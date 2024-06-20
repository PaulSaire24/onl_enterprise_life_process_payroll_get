package com.bbva.rbvd.lib.r410.impl.dao;



import com.bbva.pisd.lib.r404.PISDR404;

import java.util.List;
import java.util.Map;

public class PayrollDAO {
    private final PISDR404 pisdR404;

    public PayrollDAO(PISDR404 pisdR404) {
        this.pisdR404 = pisdR404;
    }

    public List<Map<String, Object>> getEmployeePayrollFromDB(String contractId) {
        return pisdR404.executeGetEmployeesPayroll(contractId);
    }
}

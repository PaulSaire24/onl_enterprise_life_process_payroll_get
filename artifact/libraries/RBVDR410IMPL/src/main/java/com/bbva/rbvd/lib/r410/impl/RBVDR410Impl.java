package com.bbva.rbvd.lib.r410.impl;

import com.bbva.rbvd.dto.py.payroll.EmployeePayrollResponseDTO;
import com.bbva.rbvd.dto.py.payroll.PayrollDTO;
import com.bbva.rbvd.lib.r410.impl.business.EmployeePayrolllBusiness;
import com.bbva.rbvd.lib.r410.impl.dao.PayrollDAO;
import com.bbva.rbvd.lib.r410.impl.utils.MockUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * The RBVDR410Impl class...
 */
public class RBVDR410Impl extends RBVDR410Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDR410Impl.class);

	@Override
	public EmployeePayrollResponseDTO executeGetEmployeePayrool(String quotationId) {
		LOGGER.info("***** RBVDR410Impl - executeGetEmployeePayrool START *****");
		LOGGER.info("***** RBVDR410Impl - executeGetEmployeePayrool quotationId: {} *****", quotationId);
		List<Map<String, Object>> employeePayroll = new PayrollDAO(this.pisdR404).getEmployeePayrollFromDB(quotationId);
		if (quotationId.isEmpty()) {
			return null;
		} else {
			EmployeePayrolllBusiness policyDetailBusiness = new EmployeePayrolllBusiness();
			return policyDetailBusiness.getEmployeePayroll(contractId, contractDetail);
		}
	}

	/*
	@Override
	public EmployeePayrollResponseDTO execute() {
		MockUtils mockUtils = new MockUtils();
		return mockUtils.getMockGetPayrollTrx();
	}
	 */


}

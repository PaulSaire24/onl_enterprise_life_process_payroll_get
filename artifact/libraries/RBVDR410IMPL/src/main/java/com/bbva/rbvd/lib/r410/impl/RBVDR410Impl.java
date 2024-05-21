package com.bbva.rbvd.lib.r410.impl;

import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.dao.impl.EnterpriseInsuranceGetPayrollDAOImpl;
import com.bbva.rbvd.lib.r410.transform.bean.EnterpriseInsurancePayrollBean;
import com.bbva.rbvd.lib.r410.transform.map.EnterpriseInsurancePayrollMap;
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
	public EmployeePayrollResponseDTO execute(EmployeePayrollFilterDTO input) {
		EnterpriseInsuranceGetPayrollDAOImpl enterpriseInsuranceGetPayrollDAO = new EnterpriseInsuranceGetPayrollDAOImpl(rbvdR414);
		Map<String, Object> argumentsForGetPayrollInfo = EnterpriseInsurancePayrollMap.createArgumentsForGetPayrollInfo(input.getUploadEmployeesPayrollId());
		List<Map<String,Object>> payrollInfo = enterpriseInsuranceGetPayrollDAO.getInsurancePayroll(argumentsForGetPayrollInfo);
		List<PayrollEmployeeDTO> payrollList =EnterpriseInsurancePayrollBean.getBeanInsurancePayrollDao(payrollInfo);

		EmployeePayrollResponseDTO output = generatePayroll(payrollList,input.getUploadEmployeesPayrollId());
    return output;
	}
	public static EmployeePayrollResponseDTO generatePayroll(List<PayrollEmployeeDTO> payrollList,String payrollId) {
		EmployeePayrollResponseDTO output= new EmployeePayrollResponseDTO();
		output.setId(payrollId);
		output.setPayroll(payrollList);

		return output;
	}

}

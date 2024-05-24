package com.bbva.rbvd.lib.r410.impl;

import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.dto.payroll.rimac.PayloadInsurancePayrollRequestBO;
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
	public EmployeePayrollResponseDTO executeGetPayroll(EmployeePayrollFilterDTO input) {
		LOGGER.info("*******RBVDR410Impl - executeGetPayroll START");
		LOGGER.info("*******RBVDR410Impl - executeGetPayroll Input {}",input);
		EnterpriseInsuranceGetPayrollDAOImpl enterpriseInsuranceGetPayrollDAO = new EnterpriseInsuranceGetPayrollDAOImpl(rbvdR414);

		PayloadInsurancePayrollRequestBO payloadInsurancePayrollRequestBO = new PayloadInsurancePayrollRequestBO();
		LOGGER.info("*******RBVDR410Impl - executeGetPayroll - payloadInsurancePayrollRequestBO : {}",payloadInsurancePayrollRequestBO);
		Map<String, Object> argumentsForGetPayrollInfo = EnterpriseInsurancePayrollMap.createArgumentsForGetPayrollInfo(input.getUploadEmployeesPayrollId());
		List<Map<String,Object>> payrollInfo = enterpriseInsuranceGetPayrollDAO.getInsurancePayroll(argumentsForGetPayrollInfo);

		List<PayrollEmployeeDTO> payrollList =EnterpriseInsurancePayrollBean.getBeanInsurancePayrollDao(payrollInfo);
		LOGGER.info("*******RBVDR410Impl - executeGetPayroll - payrollList : {}",payrollList);


		EmployeePayrollResponseDTO output = generatePayroll(payrollList,input.getUploadEmployeesPayrollId());
		LOGGER.info("*******RBVDR410Impl - executeGetPayroll Response {}",output);
		LOGGER.info("*******RBVDR410Impl - executeGetPayroll END");
    return output;
	}
	public static EmployeePayrollResponseDTO generatePayroll(List<PayrollEmployeeDTO> payrollList,String payrollId) {
		EmployeePayrollResponseDTO output= new EmployeePayrollResponseDTO();
		output.setId(payrollId);
		output.setPayroll(payrollList);

		return output;
	}

}

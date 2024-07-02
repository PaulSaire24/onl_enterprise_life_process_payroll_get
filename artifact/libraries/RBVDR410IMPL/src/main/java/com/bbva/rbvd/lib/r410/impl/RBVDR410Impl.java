package com.bbva.rbvd.lib.r410.impl;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.repository.PayrollDao;
import com.bbva.rbvd.lib.r410.transform.MappeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bbva.rbvd.lib.r410.business.PayrollBusiness;

public class RBVDR410Impl extends RBVDR410Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDR410Impl.class);

	@Override
	public EmployeePayrollResponseDTO executeGetInformationPayroll(EmployeePayrollFilterDTO input) {

		LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll input -> {}",input);
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("QUOTATION_ID", input.getQuotationId());
		String queryName = "PISD.SELECT_PAYROLL_EMPLOYEES";
		PayrollDao payrollDao = new PayrollDao(this.pisdR404);
		List<Map<String, Object>> result =  payrollDao.fetchDataAsMapList(queryName, arguments);
		LOGGER.info("*** pisdR404 result query -> {}", result);
		EmployeePayrollResponseDTO response = MappeBean.mapResultPayroll(result,this.applicationConfigurationService);
		PayrollBusiness.getObsPayroll(response,payrollDao);
		return response;
	}
}

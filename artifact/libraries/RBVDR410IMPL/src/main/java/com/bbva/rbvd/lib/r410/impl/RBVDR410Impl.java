package com.bbva.rbvd.lib.r410.impl;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.transform.MappeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.rbvd.lib.r410.utils.Constants;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RBVDR410Impl extends RBVDR410Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDR410Impl.class);

	@Override
	public EmployeePayrollResponseDTO executeGetInformationPayroll(EmployeePayrollFilterDTO input) {

		LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll input -> {}",input);
		try {
			Map<String, Object> arguments = new HashMap<>();
			arguments.put(Constants.Columns.QUOTATION_ID, input.getQuotationId());
			String queryName = Constants.QueryNames.SELECT_INFORMATION_PAYROLL;

			List<Map<String, Object>> result = this.pisdR404.executeGetListASingleRow(queryName, arguments);
			LOGGER.info("*** pisdR404 result query -> {}", result);
			return MappeBean.mapResultPayroll(result);
		}catch (ParseException e){
			LOGGER.info("*** RBVDR410Impl  executeGetInformationPayroll with Exception -> {}", e.getMessage());
			return null;
		}
	}
}

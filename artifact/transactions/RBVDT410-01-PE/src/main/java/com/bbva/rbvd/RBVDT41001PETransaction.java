package com.bbva.rbvd;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.rbvd.dto.getpayroll.process.dto.PayrollDTO;
import com.bbva.rbvd.dto.getpayroll.process.dto.StatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transaction to get payroll upload process
 *
 */
public class RBVDT41001PETransaction extends AbstractRBVDT41001PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDT41001PETransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {

		LOGGER.info("RBVDT41001PETransaction - execute() | START");

		String quotationId = this.getQuotationid();
		String uploadEmployeesPayrollId = this.getUploademployeespayrollid();

		LOGGER.info("RBVDT41001PETransaction - execute() | input param 1: {}",quotationId);
		LOGGER.info("RBVDT41001PETransaction - execute() | input param 2: {}",uploadEmployeesPayrollId);

		PayrollDTO data =  new PayrollDTO();
		data.setId("id data test");
		StatusDTO status = new StatusDTO();
		status.setId("COTIZADA");
		status.setName("QUOTED");
		data.setStatus(status);


		this.setData(data);
		this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);

	}

}

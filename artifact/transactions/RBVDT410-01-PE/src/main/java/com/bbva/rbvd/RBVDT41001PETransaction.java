package com.bbva.rbvd;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.rbvd.dto.getpayroll.process.dto.IdentityDocumentDTO;
import com.bbva.rbvd.dto.getpayroll.process.dto.PayrollDTO;
import com.bbva.rbvd.dto.getpayroll.process.dto.StatusPayrollDTO;
import com.bbva.rbvd.dto.getpayroll.process.dto.StatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

		StatusPayrollDTO data =  new StatusPayrollDTO();
		data.setId("id data test");
		StatusDTO status = new StatusDTO();
		status.setId("COTIZADA");
		status.setName("QUOTED");
		data.setStatus(status);
		List<PayrollDTO> payroll = new ArrayList<>();
		PayrollDTO payroll1 = new PayrollDTO();
		payroll1.setIdentityDocument(new IdentityDocumentDTO());
		payroll1.setContactDetails(null);
		payroll1.setHireDate(new Date());
		payroll1.setSalaryAmount(null);

		payroll.add(payroll1);
		data.setPayroll(payroll);

		this.setData(data);
		this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);

	}

}

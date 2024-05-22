package com.bbva.rbvd;

import com.bbva.apx.exception.business.BusinessException;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.RBVDR410;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.nonNull;


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
		RBVDR410 rbvdR410 = this.getServiceLibrary(RBVDR410.class);

		LOGGER.info("RBVDT41001PETransaction - execute() | START");

		EmployeePayrollFilterDTO input = new EmployeePayrollFilterDTO();

		input.setQuotationId(this.getQuotationid());
		input.setUploadEmployeesPayrollId(this.getUploademployeespayrollid());

		input.setSaleChannelId(String.valueOf(this.getContext().getTransactionRequest().getHeader().getHeaderParameter(RequestHeaderParamsName.CHANNELCODE)));
		input.setCreationUser(String.valueOf(this.getContext().getTransactionRequest().getHeader().getHeaderParameter(RequestHeaderParamsName.USERCODE)));
		input.setUserAudit(String.valueOf(this.getContext().getTransactionRequest().getHeader().getHeaderParameter(RequestHeaderParamsName.USERCODE)));
		input.setTraceId(String.valueOf(this.getContext().getTransactionRequest().getHeader().getHeaderParameter(RequestHeaderParamsName.REQUESTID)));
		input.setSourceBranchCode(String.valueOf(this.getContext().getTransactionRequest().getHeader().getHeaderParameter(RequestHeaderParamsName.BRANCHCODE)));
		input.setLastChangeBranchId(String.valueOf(this.getContext().getTransactionRequest().getHeader().getHeaderParameter(RequestHeaderParamsName.BRANCHCODE)));
		try {
			EmployeePayrollResponseDTO response = rbvdR410.executeGetPayroll(input);
			if (nonNull(response)) {
				LOGGER.info("RBVDT41001PETransaction - Response : {}", response.toString());
				this.setId(response.getId());
				this.setStatus(response.getStatus());
				this.setPayroll(response.getPayroll());

				LOGGER.info("RBVDT41001PETransaction - execute() | input QuotationId: {}", input.getQuotationId());
				LOGGER.info("RBVDT41001PETransaction - execute() | input EmployeesPayrollId: {}", input.getUploadEmployeesPayrollId());

				this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
			} else {
				this.setSeverity(Severity.ENR);
			}
		} catch (BusinessException be) {
			this.addAdvice(be.getAdviceCode());
			this.setSeverity(Severity.ENR);
		}
	}
}

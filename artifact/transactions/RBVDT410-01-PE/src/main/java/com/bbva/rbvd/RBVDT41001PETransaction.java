package com.bbva.rbvd;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.RBVDR410;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
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
		RBVDR033 rbvdR033 = this.getServiceLibrary(RBVDR033.class);
		LOGGER.info("Execution of RBVDT03301PETransaction");
		LOGGER.info("Header traceId: {}", this.getRequestHeader().getHeaderParameter(RequestHeaderParamsName.REQUESTID));
		PolicyDetailDTO validation = rbvdR033.executeGetInsurancePolicyDetail(this.getInsuranceContractId());
		if (validation == null) {
			setSeverity(Severity.ENR);
		} else {
			this.setId(validation.getId());
			this.setPolicynumber(validation.getPolicyNumber());
			this.setAlias(validation.getAlias());
			this.setProducttype(validation.getProductType());
			this.setProduct(validation.getProduct());
			this.setInsuredamount(validation.getInsuredAmount());
			this.setStatus(validation.getStatus());
			this.setInsurancecompany(validation.getInsuranceCompany());
			this.setPaymentconfiguration(validation.getPaymentConfiguration());
			if (validation.getCancelationDate() != null) {
				this.setCancelationdate(validation.getCancelationDate());
			}
			this.setValidityperiod(validation.getValidityPeriod());
			this.setCurrentinstallment(validation.getCurrentInstallment());
			this.setPremiumdebt(validation.getPremiumDebt());
			this.setRenewalpolicy(validation.getRenewalPolicy());
			this.setCertificatenumber(validation.getCertificateNumber());
			this.setSubscriptiontype(validation.getSubscriptionType());
			this.setBusinessagent(validation.getBusinessAgent());
			this.setBank(validation.getBank());
			if (validation.getExternalDocumentationSendDate() != null) {
				this.setExternaldocumentationsenddate(validation.getExternalDocumentationSendDate());
			}
			this.setInstallmentPayment(validation.getInstallmentPayment());

			LOGGER.info("Header traceId: {}", validation);

		}

	}

}

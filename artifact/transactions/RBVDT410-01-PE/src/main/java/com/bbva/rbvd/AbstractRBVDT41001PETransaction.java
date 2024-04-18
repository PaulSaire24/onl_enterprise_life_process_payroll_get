package com.bbva.rbvd;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.rbvd.dto.payroll.dto.DescriptionDTO;
import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;

import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractRBVDT41001PETransaction extends AbstractTransaction {

	public AbstractRBVDT41001PETransaction(){
	}


	/**
	 * Return value for input parameter quotationId
	 */
	protected String getQuotationid(){
		return (String)this.getParameter("quotationId");
	}

	/**
	 * Return value for input parameter uploadEmployeesPayrollId
	 */
	protected String getUploademployeespayrollid(){
		return (String)this.getParameter("uploadEmployeesPayrollId");
	}

	/**
	 * Set value for StatusPayrollDTO output parameter data
	 */
	//provide the setters for these threee parameters id, status, payroll
	protected void setId(final String field){
		this.addParameter("id", field);
	}

	protected void setStatus(final DescriptionDTO field){
		this.addParameter("status", field);
	}
	protected void setPayroll(final List<PayrollEmployeeDTO> field){
		this.addParameter("payroll", field);
	}

}

package com.bbva.rbvd;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.rbvd.dto.getpayroll.process.dto.PayrollDTO;

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
	 * Set value for PayrollDTO output parameter data
	 */
	protected void setData(final PayrollDTO field){
		this.addParameter("data", field);
	}
}

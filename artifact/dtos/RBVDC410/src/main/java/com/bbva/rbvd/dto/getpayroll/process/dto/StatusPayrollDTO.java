package com.bbva.rbvd.dto.getpayroll.process.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The StatusPayrollDTO class...
 */
public class StatusPayrollDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;


	private String id;
	private StatusDTO status;
	private List<PayrollDTO> payroll;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public List<PayrollDTO> getPayroll() {
		return payroll;
	}

	public void setPayroll(List<PayrollDTO> payroll) {
		this.payroll = payroll;
	}

	@Override
	public String toString() {
		return "StatusPayrollDTO{" +
				"id='" + id + '\'' +
				", status=" + status +
				", payroll=" + payroll +
				'}';
	}
}

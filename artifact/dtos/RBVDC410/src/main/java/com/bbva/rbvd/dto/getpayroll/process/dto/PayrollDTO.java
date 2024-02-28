package com.bbva.rbvd.dto.getpayroll.process.dto;

import java.io.Serializable;

/**
 * The PayrollDTO class...
 */
public class PayrollDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;


	private String id;
	private StatusDTO status;


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


	@Override
	public String toString() {
		return "PayrollDTO{" +
				"id='" + id + '\'' +
				", status=" + status +
				'}';
	}
}

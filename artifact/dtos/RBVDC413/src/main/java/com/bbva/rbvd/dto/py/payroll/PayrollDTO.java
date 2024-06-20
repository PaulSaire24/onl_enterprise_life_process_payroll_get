package com.bbva.rbvd.dto.py.payroll;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The PayrollDTO class...
 */
public class PayrollDTO implements Serializable  {

	private String payrollId;
	private String movementStatus;
	private String employeeFirstName;
	private String employeeFirstLastName;
	private String employeeSecondLastName;
	private String employeeBirthDate;
	private String employeeGenderType;
	private String employeeStatus;
	private String employeePersonalType;
	private String employeePersonalId;
	private String employeeEmailName;
	private String employeeCellPhoneNumberId;
	private String jobPositionEeStartDate;
	private String jobPositionEeEndDate;
	private BigDecimal monthPaymentAmount;
	private String uploadedStatusType;

	public String getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(String payrollId) {
		this.payrollId = payrollId;
	}

	public String getMovementStatus() {
		return movementStatus;
	}

	public void setMovementStatus(String movementStatus) {
		this.movementStatus = movementStatus;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeFirstLastName() {
		return employeeFirstLastName;
	}

	public void setEmployeeFirstLastName(String employeeFirstLastName) {
		this.employeeFirstLastName = employeeFirstLastName;
	}

	public String getEmployeeSecondLastName() {
		return employeeSecondLastName;
	}

	public void setEmployeeSecondLastName(String employeeSecondLastName) {
		this.employeeSecondLastName = employeeSecondLastName;
	}

	public String getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public void setEmployeeBirthDate(String employeeBirthDate) {
		this.employeeBirthDate = employeeBirthDate;
	}

	public String getEmployeeGenderType() {
		return employeeGenderType;
	}

	public void setEmployeeGenderType(String employeeGenderType) {
		this.employeeGenderType = employeeGenderType;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeePersonalType() {
		return employeePersonalType;
	}

	public void setEmployeePersonalType(String employeePersonalType) {
		this.employeePersonalType = employeePersonalType;
	}

	public String getEmployeePersonalId() {
		return employeePersonalId;
	}

	public void setEmployeePersonalId(String employeePersonalId) {
		this.employeePersonalId = employeePersonalId;
	}

	public String getEmployeeEmailName() {
		return employeeEmailName;
	}

	public void setEmployeeEmailName(String employeeEmailName) {
		this.employeeEmailName = employeeEmailName;
	}

	public String getEmployeeCellPhoneNumberId() {
		return employeeCellPhoneNumberId;
	}

	public void setEmployeeCellPhoneNumberId(String employeeCellPhoneNumberId) {
		this.employeeCellPhoneNumberId = employeeCellPhoneNumberId;
	}

	public String getJobPositionEeStartDate() {
		return jobPositionEeStartDate;
	}

	public void setJobPositionEeStartDate(String jobPositionEeStartDate) {
		this.jobPositionEeStartDate = jobPositionEeStartDate;
	}

	public String getJobPositionEeEndDate() {
		return jobPositionEeEndDate;
	}

	public void setJobPositionEeEndDate(String jobPositionEeEndDate) {
		this.jobPositionEeEndDate = jobPositionEeEndDate;
	}

	public BigDecimal getMonthPaymentAmount() {
		return monthPaymentAmount;
	}

	public void setMonthPaymentAmount(BigDecimal monthPaymentAmount) {
		this.monthPaymentAmount = monthPaymentAmount;
	}

	public String getUploadedStatusType() {
		return uploadedStatusType;
	}

	public void setUploadedStatusType(String uploadedStatusType) {
		this.uploadedStatusType = uploadedStatusType;
	}

	@Override
	public String toString() {
		return "PayrollDTO{" +
				"payrollId='" + payrollId + '\'' +
				", movementStatus='" + movementStatus + '\'' +
				", employeeFirstName='" + employeeFirstName + '\'' +
				", employeeFirstLastName='" + employeeFirstLastName + '\'' +
				", employeeSecondLastName='" + employeeSecondLastName + '\'' +
				", employeeBirthDate='" + employeeBirthDate + '\'' +
				", employeeGenderType='" + employeeGenderType + '\'' +
				", employeeStatus='" + employeeStatus + '\'' +
				", employeePersonalType='" + employeePersonalType + '\'' +
				", employeePersonalId='" + employeePersonalId + '\'' +
				", employeeEmailName='" + employeeEmailName + '\'' +
				", employeeCellPhoneNumberId='" + employeeCellPhoneNumberId + '\'' +
				", jobPositionEeStartDate='" + jobPositionEeStartDate + '\'' +
				", jobPositionEeEndDate='" + jobPositionEeEndDate + '\'' +
				", monthPaymentAmount=" + monthPaymentAmount +
				", uploadedStatusType='" + uploadedStatusType + '\'' +
				'}';
	}


	public static final class Builder {
		private PayrollDTO payrollDTO;

		private Builder() {
			payrollDTO = new PayrollDTO();
		}

		public static Builder an() {
			return new Builder();
		}

		public Builder payrollId(String payrollId) {
			payrollDTO.setPayrollId(payrollId);
			return this;
		}

		public Builder movementStatus(String movementStatus) {
			payrollDTO.setMovementStatus(movementStatus);
			return this;
		}

		public Builder employeeFirstName(String employeeFirstName) {
			payrollDTO.setEmployeeFirstName(employeeFirstName);
			return this;
		}

		public Builder employeeFirstLastName(String employeeFirstLastName) {
			payrollDTO.setEmployeeFirstLastName(employeeFirstLastName);
			return this;
		}

		public Builder employeeSecondLastName(String employeeSecondLastName) {
			payrollDTO.setEmployeeSecondLastName(employeeSecondLastName);
			return this;
		}

		public Builder employeeBirthDate(String employeeBirthDate) {
			payrollDTO.setEmployeeBirthDate(employeeBirthDate);
			return this;
		}

		public Builder employeeGenderType(String employeeGenderType) {
			payrollDTO.setEmployeeGenderType(employeeGenderType);
			return this;
		}

		public Builder employeeStatus(String employeeStatus) {
			payrollDTO.setEmployeeStatus(employeeStatus);
			return this;
		}

		public Builder employeePersonalType(String employeePersonalType) {
			payrollDTO.setEmployeePersonalType(employeePersonalType);
			return this;
		}

		public Builder employeePersonalId(String employeePersonalId) {
			payrollDTO.setEmployeePersonalId(employeePersonalId);
			return this;
		}

		public Builder employeeEmailName(String employeeEmailName) {
			payrollDTO.setEmployeeEmailName(employeeEmailName);
			return this;
		}

		public Builder employeeCellPhoneNumberId(String employeeCellPhoneNumberId) {
			payrollDTO.setEmployeeCellPhoneNumberId(employeeCellPhoneNumberId);
			return this;
		}

		public Builder jobPositionEeStartDate(String jobPositionEeStartDate) {
			payrollDTO.setJobPositionEeStartDate(jobPositionEeStartDate);
			return this;
		}

		public Builder jobPositionEeEndDate(String jobPositionEeEndDate) {
			payrollDTO.setJobPositionEeEndDate(jobPositionEeEndDate);
			return this;
		}

		public Builder monthPaymentAmount(BigDecimal monthPaymentAmount) {
			payrollDTO.setMonthPaymentAmount(monthPaymentAmount);
			return this;
		}

		public Builder uploadedStatusType(String uploadedStatusType) {
			payrollDTO.setUploadedStatusType(uploadedStatusType);
			return this;
		}

		public PayrollDTO build() {
			return payrollDTO;
		}
	}
}

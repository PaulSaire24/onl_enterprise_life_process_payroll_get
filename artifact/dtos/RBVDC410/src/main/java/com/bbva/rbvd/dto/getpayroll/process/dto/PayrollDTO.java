package com.bbva.rbvd.dto.getpayroll.process.dto;

import java.util.Date;
import java.util.List;

public class PayrollDTO {

    private IdentityDocumentDTO identityDocument;
    private List<ContactDetailsDTO> contactDetails;
    private Date hireDate;
    private SalaryAmountDTO salaryAmount;


    public IdentityDocumentDTO getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(IdentityDocumentDTO identityDocument) {
        this.identityDocument = identityDocument;
    }

    public List<ContactDetailsDTO> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(List<ContactDetailsDTO> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public SalaryAmountDTO getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(SalaryAmountDTO salaryAmount) {
        this.salaryAmount = salaryAmount;
    }


    @Override
    public String toString() {
        return "PayrollDTO{" +
                "identityDocument=" + identityDocument +
                ", contactDetails=" + contactDetails +
                ", hireDate=" + hireDate +
                ", salaryAmount=" + salaryAmount +
                '}';
    }
}

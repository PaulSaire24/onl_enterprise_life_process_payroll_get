package com.bbva.rbvd.dto.getpayroll.process.dto;

public class IdentityDocumentDTO {

    private DocumentTypeDTO documentType;
    private String documentNumber;


    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }


    @Override
    public String toString() {
        return "IdentityDocumentDTO{" +
                "documentType=" + documentType +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}

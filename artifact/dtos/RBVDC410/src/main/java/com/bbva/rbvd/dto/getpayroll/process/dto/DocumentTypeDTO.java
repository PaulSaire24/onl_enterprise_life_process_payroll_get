package com.bbva.rbvd.dto.getpayroll.process.dto;

public class DocumentTypeDTO {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "DocumentTypeDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}

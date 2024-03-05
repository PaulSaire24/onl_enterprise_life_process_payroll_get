package com.bbva.rbvd.dto.getpayroll.process.dto;

public class ContactDetailsDTO {

    private ContactDTO contact;


    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactDetailsDTO{" +
                "contact=" + contact +
                '}';
    }
}

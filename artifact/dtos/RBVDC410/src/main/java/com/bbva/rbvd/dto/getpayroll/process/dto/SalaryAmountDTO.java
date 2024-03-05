package com.bbva.rbvd.dto.getpayroll.process.dto;

public class SalaryAmountDTO {

    private Double amount;
    private String currency;


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "SalaryAmountDTO{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}

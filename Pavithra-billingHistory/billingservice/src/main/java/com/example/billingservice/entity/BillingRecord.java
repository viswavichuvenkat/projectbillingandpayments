package com.example.billingservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class BillingRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_seq")
    @JsonProperty("billingID")
    @SequenceGenerator(name = "billing_seq", sequenceName = "billing_id_seq", allocationSize = 1)
    private Long billingID;
    @JsonProperty("customerID")
    private Long customerID;
    private Long invoiceID;
    private BigDecimal amount;
    private LocalDate billingDate;
    @JsonProperty("billingStatus")
    private String billingStatus;
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "BillingRecord [billingID=" + billingID + ", customerID=" + customerID + ", invoiceID=" + invoiceID
                + ", amount=" + amount + ", billingDate=" + billingDate + ", billingStatus=" + billingStatus
                + ", dueDate=" + dueDate + "]";
    }

    // Getters and Setters
    public Long getBillingID() {
        return billingID;
    }

    public void setBillingID(Long billingID) {
        this.billingID = billingID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}


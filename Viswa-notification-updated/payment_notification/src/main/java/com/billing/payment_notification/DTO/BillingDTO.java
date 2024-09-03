package com.billing.payment_notification.DTO;

public class BillingDTO {

    private Long billingId;
    private Long customerID;
    private String billingStatus;

    @Override
    public String toString() {
        return "BillingRecord [billingID=" + billingId + ", customerID=" + customerID + ", billingStatus=" + billingStatus + "]";
    }

    public Long getBillingID() {
        return billingId;
    }

    public void setBillingID(Long billingID) {
        this.billingId = billingID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    public BillingDTO() {
    }

    public BillingDTO(Long billingId, Long customerID, String billingStatus) {
        this.billingId = billingId;
        this.customerID = customerID;
        this.billingStatus = billingStatus;
    }


    
    
}



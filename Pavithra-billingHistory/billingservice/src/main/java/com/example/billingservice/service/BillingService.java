package com.example.billingservice.service;

import com.example.billingservice.entity.BillingRecord;
import com.example.billingservice.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public BillingRecord createBillingRecord(BillingRecord billingRecord) {
        return billingRepository.save(billingRecord);
    }

    public BillingRecord updateBillingRecord(Long billingID, BillingRecord updatedRecord) {
        return billingRepository.findById(billingID)
                .map(record -> {
                    record.setAmount(updatedRecord.getAmount());
                    record.setBillingDate(updatedRecord.getBillingDate());
                    record.setBillingStatus(updatedRecord.getBillingStatus());
                    record.setDueDate(updatedRecord.getDueDate());
                    return billingRepository.save(record);
                })
                .orElseThrow(() -> new RuntimeException("BillingRecord not found"));
    }

    public BillingRecord retrieveBillingRecord(Long billingID) {
        return billingRepository.findById(billingID)
                .orElseThrow(() -> new RuntimeException("BillingRecord not found"));
    }

    public void deleteBillingRecord(Long billingID) {
        billingRepository.deleteById(billingID);
    }

    public List<BillingRecord> getBillingHistory(Long customerID) {
        return billingRepository.findByCustomerID(customerID);
    }
}

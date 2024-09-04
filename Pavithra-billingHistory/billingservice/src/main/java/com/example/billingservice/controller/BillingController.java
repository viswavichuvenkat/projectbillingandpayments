    package com.example.billingservice.controller;

import com.example.billingservice.entity.BillingRecord;
import com.example.billingservice.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<BillingRecord> createBillingRecord(@RequestBody BillingRecord billingRecord) {
        BillingRecord createdRecord = billingService.createBillingRecord(billingRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{billingID}")
    public ResponseEntity<BillingRecord> updateBillingRecord(
            @PathVariable Long billingID,
            @RequestBody BillingRecord updatedRecord) {
        BillingRecord updated = billingService.updateBillingRecord(billingID, updatedRecord);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{billingID}")
    public ResponseEntity<BillingRecord> retrieveBillingRecord(@PathVariable Long billingID) {
        BillingRecord record = billingService.retrieveBillingRecord(billingID);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @DeleteMapping("/{billingID}")
    public ResponseEntity<Void> deleteBillingRecord(@PathVariable Long billingID) {
        billingService.deleteBillingRecord(billingID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer/{customerID}")
    public ResponseEntity<List<BillingRecord>> getBillingHistory(@PathVariable Long customerID) {
        List<BillingRecord> history = billingService.getBillingHistory(customerID);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}

package com.example.billingservice.repository;

import com.example.billingservice.entity.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<BillingRecord, Long> {
    
    List<BillingRecord> findByCustomerID(Long customerID);
}

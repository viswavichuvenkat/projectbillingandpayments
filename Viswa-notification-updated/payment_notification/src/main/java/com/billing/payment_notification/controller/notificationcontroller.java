package com.billing.payment_notification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.billing.payment_notification.entity.notification;
import com.billing.payment_notification.service.notificationservice;

@RestController
@RequestMapping("api/notifications")

public class notificationcontroller {

    @Autowired
    private notificationservice notificationService;

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody notification  request) {
        notificationService.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully.");
    }

    @PostMapping("/test")
    public ResponseEntity<String> sendTestNotification() {
        notificationService.sendTestNotification();
        return ResponseEntity.ok("Test notification sent successfully.");
    }

    @PostMapping("/billing/{billingId}")
    public void sendNotification(@PathVariable Long billingId) {
    notificationService.processAndSendNotification(billingId);
}
    
}

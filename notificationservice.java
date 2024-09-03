package com.billing.payment_notification.service;


import com.billing.payment_notification.DTO.BillingDTO;
import com.billing.payment_notification.DTO.CustomerDTO;
import com.billing.payment_notification.entity.notification;

import com.billing.payment_notification.repository.NotificationRepository;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;



@Service
public class notificationservice {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificationRepository notificationrepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationRepository notificationRepo;

    

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${billing.service.url}")
    private String billingServiceUrl;

    public void processAndSendNotification(Long billingId) {
        // Fetch billing details using billingId
        BillingDTO billing = fetchBillingDetails(billingId);
        
        if (billing != null && "PENDING".equals(billing.getBillingStatus())) {
            // Fetch customer details using customerId from billing
            CustomerDTO customer = fetchCustomerById(billing.getCustomerID());
            
            if (customer != null) {
                // Create and populate the notification entity
                notification newNotification = new notification();
                newNotification.setRecipient(customer.getEmail()); // Set the recipient email
                newNotification.setSubject("Payment Pending: Immediate Action Required");
                newNotification.setMessage("Dear Customer, your payment for Billing ID " + billingId + " is pending. Please complete the payment to avoid service disruption.");
    
                // Save the notification entity to the database
                notificationRepo.save(newNotification);
    
                // Send the email
                sendNotification(newNotification);
            } else {
                System.err.println("Customer not found for ID: " + billing.getCustomerID());
            }
        } else {
            System.err.println("Billing not found or payment status is not PENDING for ID: " + billingId);
        }
    }


     


    

    

    public CustomerDTO fetchCustomerById(Long customerId) {
        String url = String.format("http://localhost:9696/customers/%s",  customerId);
       ResponseEntity<CustomerDTO> response = restTemplate.getForEntity(url, CustomerDTO.class);
        return response.getBody();
    }
    

   private BillingDTO fetchBillingDetails(Long billingId) {
      String url = String.format("http://localhost:9393/api/billings/%s", billingId);
       ResponseEntity<BillingDTO> response = restTemplate.getForEntity(url, BillingDTO.class);
        return response.getBody();
   }

   
    
       

   
    

    public void sendNotification(notification request) {
        try {
            // Create and send email
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getRecipient());
            message.setSubject(request.getSubject());
            message.setText(request.getMessage());
            mailSender.send(message);
            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    
        // Save the notification to the database
        notification notify = new notification();
        notify.setRecipient(request.getRecipient());
        notify.setSubject(request.getSubject());
        notify.setMessage(request.getMessage());
        notificationrepo.save(notify);
    }
    
    public void sendTestNotification() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("test@example.com");
        message.setSubject("Test Notification");
        message.setText("This is a test notification.");
        mailSender.send(message);
    }
}


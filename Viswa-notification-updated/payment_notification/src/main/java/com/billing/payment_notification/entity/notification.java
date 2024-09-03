package com.billing.payment_notification.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipient;
    private String subject;
    private String message;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public notification() {
    }

    public notification(Long id, String recipient, String subject, String message) {
        this.id = id;
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public String toString() {
        return "notification [id=" + id + ", recipient=" + recipient + ", subject=" + subject + ", message=" + message
                + "]";
    }
    
    
    

}







   


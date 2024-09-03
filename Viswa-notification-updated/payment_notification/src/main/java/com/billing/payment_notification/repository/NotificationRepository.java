package com.billing.payment_notification.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.payment_notification.entity.notification;


@Repository
public interface NotificationRepository extends JpaRepository<notification, Long> {
}

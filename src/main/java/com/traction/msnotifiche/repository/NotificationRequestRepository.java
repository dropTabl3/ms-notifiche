package com.traction.msnotifiche.repository;

import com.traction.msnotifiche.model.NotificationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface NotificationRequestRepository extends JpaRepository<NotificationRequest, BigInteger> {
    List<NotificationRequest> findByStatus(String status);
    List<NotificationRequest> findByType(String type);
}

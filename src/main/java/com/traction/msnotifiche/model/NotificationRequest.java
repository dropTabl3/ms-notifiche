package com.traction.msnotifiche.model;

import com.traction.msnotifiche.constants.NotificationStatus;
import com.traction.msnotifiche.constants.NotificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "notification_request")
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(name = "recipient", nullable = false, length = 255)
    @NotBlank
    private String recipient;

    @Column(name = "message", nullable = false, length = 255)
    @NotBlank
    private String message;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @Column(name = "campaign_id", nullable = false)
    @NotNull
    private UUID campaignId;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

package com.traction.msnotifiche.dto;

import com.traction.msnotifiche.constants.NotificationStatus;
import com.traction.msnotifiche.constants.NotificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NotificationRequestDTO {
    @NotNull(message = "Il tipo di notifica non può essere null")
    private NotificationType type;

    @NotBlank(message = "Il destinatario non può essere vuoto")
    private String recipient;

    @NotBlank(message = "Il messaggio non può essere vuoto")
    private String message;

    @NotNull(message = "campaign_id non può essere null")
    private UUID campaignId;

    private NotificationStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


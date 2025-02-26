package com.traction.msnotifiche.controller;

import com.traction.msnotifiche.constants.NotificationType;
import com.traction.msnotifiche.dto.NotificationRequestDTO;
import com.traction.msnotifiche.mapper.NotificationMapper;
import com.traction.msnotifiche.model.NotificationRequest;
import com.traction.msnotifiche.repository.NotificationRequestRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificationControllerTest {

    @Mock
    private NotificationRequestRepository requestRepository;

    @Mock
    private NotificationMapper notificationMapper;

    @InjectMocks
    private NotificationController notificationController;

    @Test
    public void testCreateNotification() {
        // Arrange
        NotificationRequestDTO dto = new NotificationRequestDTO();
        dto.setType(NotificationType.EMAIL);
        dto.setRecipient("test@example.com");
        dto.setMessage("Test message");

        NotificationRequest request = new NotificationRequest();
        request.setId(BigInteger.valueOf(1));
        request.setType(NotificationType.EMAIL);
        request.setRecipient("test@example.com");
        request.setMessage("Test message");

        when(notificationMapper.mapToEntity(any(NotificationRequestDTO.class))).thenReturn(request);
        when(requestRepository.save(any(NotificationRequest.class))).thenReturn(request);

        // Act
        ResponseEntity<Void> response = notificationController.createNotification(dto);

        // Assert
        assertEquals(202, response.getStatusCodeValue());
    }
    @Test
    @Disabled
    public void testGetAllNotifications() {
        // Arrange
        List<NotificationRequest> requests = List.of(
                NotificationRequest.builder()
                        .id(BigInteger.valueOf(1))
                        .type(NotificationType.EMAIL)
                        .recipient("test@example.com")
                        .message("Test message")
                        .build(),
                NotificationRequest.builder()
                        .id(BigInteger.valueOf(2))
                        .type(NotificationType.SMS)
                        .recipient("1234567890")
                        .message("Test message")
                        .build()
        );

        when(requestRepository.findAll()).thenReturn(requests);

        // Act
        ResponseEntity<List<NotificationRequestDTO>> response = notificationController.getAllNotifications();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }
}
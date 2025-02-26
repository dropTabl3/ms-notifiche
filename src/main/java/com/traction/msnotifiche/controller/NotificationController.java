package com.traction.msnotifiche.controller;

import com.traction.msnotifiche.dto.NotificationRequestDTO;
import com.traction.msnotifiche.mapper.NotificationMapper;
import com.traction.msnotifiche.repository.NotificationRequestRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Tag(name = "Notification Controller", description = "APIs for managing notifications")
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @Resource
    private NotificationRequestRepository requestRepository;
    @Resource
    private NotificationMapper notificationMapper;

    @Operation(summary = "Create a new notification",
            description = "Creates a new notification with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notification created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<Void> createNotification(@RequestBody NotificationRequestDTO dto) {
        try {
            requestRepository.save(notificationMapper.mapToEntity(dto));
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @Operation(summary = "Get all notifications",
            description = "Get all notifications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notifications found successfully",
                    content = @Content(schema = @Schema(implementation = NotificationRequestDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<NotificationRequestDTO>> getAllNotifications() {
        try {
            return ResponseEntity.ok(notificationMapper.mapToDTOList(requestRepository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}

package com.traction.msnotifiche.mapper;

import com.traction.msnotifiche.dto.NotificationRequestDTO;
import com.traction.msnotifiche.model.NotificationRequest;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface NotificationMapper {
    List<NotificationRequestDTO> mapToDTOList(List<NotificationRequest> notificationRequests);
    NotificationRequestDTO mapToDTO(NotificationRequest notificationRequest);
    NotificationRequest mapToEntity(NotificationRequestDTO notificationRequestDTO);
}

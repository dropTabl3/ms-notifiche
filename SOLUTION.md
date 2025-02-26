# Project Architecture and Design Patterns

## Architecture Overview
- The application follows a typical Spring Boot microservice architecture.
- It uses a layered architecture with controllers, services, repositories, and DTOs.
- The main components include NotificationController, NotificationRequestRepository, and NotificationMapper.

## Design Patterns Used

0. Domain Driven Design (DDD)
   - Purpose: Encapsulates domain logic and business rules.
   - Implementation: NotificationRequest entity, NotificationType enum, NotificationStatus enum.
   
1. DTO (Data Transfer Object)
    - Purpose: Separates the API model from the internal data model.
    - Implementation: NotificationRequestDTO class.

2. Repository Pattern
    - Purpose: Abstracts data persistence operations.
    - Implementation: NotificationRequestRepository interface.

3. Mapper Pattern
    - Purpose: Converts between entity and DTO objects.
    - Implementation: NotificationMapper interface.

4. Builder Pattern
    - Purpose: Simplifies object creation, especially for testing.
    - Implementation: Used in NotificationRequest entity.

## Resource Efficiency
- Use of Lombok to reduce boilerplate code, improving maintainability.
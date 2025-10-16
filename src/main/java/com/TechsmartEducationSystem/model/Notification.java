package com.TechsmartEducationSystem.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;
}

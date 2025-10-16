package com.TechsmartEducationSystem.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="discussions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discussion {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime sentAt;

    @ManyToOne
    private User sender;

    @ManyToOne
    private Course course;
}

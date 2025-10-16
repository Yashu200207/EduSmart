package com.TechsmartEducationSystem.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="certificates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String courseName;
    private LocalDateTime generatedAt;
}

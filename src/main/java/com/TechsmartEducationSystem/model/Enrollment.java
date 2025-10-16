package com.TechsmartEducationSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="enrollments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    private int progress;
}

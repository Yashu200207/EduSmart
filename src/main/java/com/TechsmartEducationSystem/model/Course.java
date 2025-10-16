package com.TechsmartEducationSystem.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="instructor_id")
    private User courseInstructor;

    @ElementCollection
    private List<String> lessons;
}

package com.TechsmartEducationSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="quizzes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String question;
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
}

package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.Quiz;
import com.TechsmartEducationSystem.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/course/{courseId}")
    public List<Quiz> getQuizzes(@PathVariable Long courseId){
        return quizService.getByCourse(courseId);
    }

    @PostMapping("/grade/{courseId}")
    public Map<String,Integer> gradeQuiz(@PathVariable Long courseId, @RequestBody Map<Long,String> answers){
        int score = quizService.grade(courseId, answers);
        return Map.of("score", score);
    }
}

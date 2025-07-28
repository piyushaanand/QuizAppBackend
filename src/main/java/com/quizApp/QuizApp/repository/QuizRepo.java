package com.quizApp.QuizApp.repository;

import com.quizApp.QuizApp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}

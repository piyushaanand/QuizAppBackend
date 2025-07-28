package com.quizApp.QuizApp.services;

import com.quizApp.QuizApp.models.Question;
import com.quizApp.QuizApp.models.QuestionWrapper;
import com.quizApp.QuizApp.models.Quiz;
import com.quizApp.QuizApp.models.Response;
import com.quizApp.QuizApp.repository.QuestionRepo;
import com.quizApp.QuizApp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepo.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> qs = quizRepo.findById(id);
        List<Question> questionsFromDb = qs.get().getQuestion();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion_Title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestion();
        int right = 0;
        int i = 0;
        for(Response res : response){
            if(res.getResponse().equals(questions.get(i).getRight_Answer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}

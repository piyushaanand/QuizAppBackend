package com.quizApp.QuizApp.services;

import com.quizApp.QuizApp.models.Question;
import com.quizApp.QuizApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategroy(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepo.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        if(questionRepo.existsById(id)){
            questionRepo.deleteById(id);
            return ResponseEntity.ok("Question has been deleted Successfully ");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Qn Not Found");
        }
    }

    public ResponseEntity<String> updateQuestion(int id, Question question) {
        Optional<Question> o = questionRepo.findById(id);
        if(o.isPresent()){
            Question q = o.get();
            q.setQuestion_Title(question.getQuestion_Title());
            q.setOption1(question.getOption1());
            q.setOption2(question.getOption2());
            q.setOption3(question.getOption3());
            q.setOption4(question.getOption4());
            q.setRight_Answer(question.getRight_Answer());
            q.setDifficultylevel(question.getDifficultylevel());
            q.setCategory(question.getCategory());
            questionRepo.save(q);
            return ResponseEntity.ok("Updated");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Qn Not Found");
        }

    }
}

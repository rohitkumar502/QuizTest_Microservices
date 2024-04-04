package com.question.serviceImpl;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepos;

    public QuestionServiceImpl(QuestionRepository questionRepos) {
        this.questionRepos = questionRepos;
    }

    @Override
    public Question create(Question question) {
        return questionRepos.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepos.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepos.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepos.findByQuizId(quizId);
    }


}

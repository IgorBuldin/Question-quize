package by.igorbuldin.service;

import by.igorbuldin.entity.Answer;
import by.igorbuldin.entity.Question;
import by.igorbuldin.repository.AnswerRepository;
import by.igorbuldin.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public boolean save(Question question) {
        questionRepository.save(question);
        return true;
    }

    public Question getById(long id) {
        return questionRepository.getOne(id);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public void delete(long id) {
        questionRepository.deleteById(id);
    }

    public boolean update(Question question) {
        if (questionRepository.existsById(question.getId())) {
            questionRepository.save(question);
            return true;
        }
        return false;
    }
}
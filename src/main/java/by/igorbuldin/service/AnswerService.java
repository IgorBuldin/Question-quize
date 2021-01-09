package by.igorbuldin.service;

import by.igorbuldin.entity.Answer;
import by.igorbuldin.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public boolean save(Answer answer) {
        answerRepository.save(answer);
        return true;
    }

    public Answer getById(long id) {
        return answerRepository.getOne(id);
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public void delete(long id) {
        answerRepository.deleteById(id);
    }

    public boolean update(Answer answer) {
        if (answerRepository.existsById(answer.getId())) {
            answerRepository.save(answer);
            return true;
        }
        return false;
    }
}

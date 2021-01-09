package by.igorbuldin.controller;

import by.igorbuldin.entity.Answer;
import by.igorbuldin.entity.Question;
import by.igorbuldin.service.AnswerService;
import by.igorbuldin.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @PostMapping
    public ResponseEntity<Boolean> save(@Valid @RequestBody Answer answer) {
        if (answerService.save(answer)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<Answer> getById(@RequestParam long id) {
        return  new ResponseEntity<>(answerService.getById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Answer>> getAll() {
        return new ResponseEntity<>(answerService.getAll(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam long id) {
        answerService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping
    public ResponseEntity<Boolean> update(@Valid @RequestBody Answer answer) {
        if (answerService.update(answer)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
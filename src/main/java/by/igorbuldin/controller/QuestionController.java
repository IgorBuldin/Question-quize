package by.igorbuldin.controller;

import by.igorbuldin.entity.Question;
import by.igorbuldin.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping
    public ResponseEntity<Boolean> save(@Valid @RequestBody Question question) {
        if (questionService.save(question)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<Question> getById(@RequestParam long id) {
        return  new ResponseEntity<>(questionService.getById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Question>> getAll() {
        return new ResponseEntity<>(questionService.getAll(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam long id) {
        questionService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping
    public ResponseEntity<Boolean> update(@Valid @RequestBody Question question) {
        if ( questionService.update(question)){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}


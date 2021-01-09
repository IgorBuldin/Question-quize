package by.igorbuldin.controller;

import by.igorbuldin.entity.Category;
import by.igorbuldin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Boolean> save(@Valid @RequestBody Category category) {
        if (categoryService.save(category)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<Category> getById(@RequestParam long id) {
        return  new ResponseEntity<>(categoryService.getById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity <Boolean> delete(@RequestParam long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}


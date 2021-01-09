package by.igorbuldin.service;

import by.igorbuldin.entity.Category;
import by.igorbuldin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
private CategoryRepository categoryRepository;

    public boolean save(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    public Category getById(long id) {
        return categoryRepository.getOne(id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void delete(long id) {
        categoryRepository.deleteById(id);
    }

    public boolean update(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

}


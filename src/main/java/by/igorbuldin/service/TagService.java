package by.igorbuldin.service;
import by.igorbuldin.entity.Tag;
import by.igorbuldin.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public boolean save(Tag tag) {
        if (tagRepository.existsByName(tag.getName())) {
            return false;
        }
        tagRepository.save(tag);
        return true;
    }

    public Tag getById(long id) {
        return tagRepository.getOne(id);
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public void delete(long id) {
        tagRepository.deleteById(id);
    }

    public boolean update(Tag tag) {
        if (tagRepository.existsById(tag.getId())) {
            tagRepository.save(tag);
            return true;
        }
        return false;
    }
}

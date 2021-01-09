package by.igorbuldin.repository;

import by.igorbuldin.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    boolean existsByName(String name);
}
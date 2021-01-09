package by.igorbuldin.repository;

import by.igorbuldin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    void deleteByUsername(String username);
    User getUserByUsername(String username);

}

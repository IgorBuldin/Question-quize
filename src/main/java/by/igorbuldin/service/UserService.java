package by.igorbuldin.service;

import by.igorbuldin.entity.User;
import by.igorbuldin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;

        public boolean addUser(User user) {
            userRepository.save(user);
            return true;
        }

        public boolean addUsers(List<User> users) {
            userRepository.saveAll(users);
            return true;
        }

        public void deleteUser(String username) {
            userRepository.deleteByUsername(username);

        }

        public User getByUsername(String username) {
            return userRepository.getUserByUsername(username);

        }

        public boolean updateUser(User user) {
            if (userRepository.existsById(user.getId())) {
                userRepository.save(user);
                return true;
            }
            return false;
        }
    }



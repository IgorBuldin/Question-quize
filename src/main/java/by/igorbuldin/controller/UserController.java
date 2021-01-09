package by.igorbuldin.controller;

import by.igorbuldin.entity.User;
import by.igorbuldin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Boolean> addUser(@Valid @RequestBody User user) {
        if (userService.addUser(user)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteUser(@Valid @RequestParam String username) {
        userService.deleteUser(username);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/updateUse")
    public ResponseEntity<Boolean> updateUser(@Valid @RequestBody User user) {
        if (userService.updateUser(user)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getByUsername")
    public ResponseEntity<User> getByUsername(@Valid @RequestParam String username) {
        User byUsername = userService.getByUsername(username);
        if (byUsername!= null){
            return new ResponseEntity<>(byUsername,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

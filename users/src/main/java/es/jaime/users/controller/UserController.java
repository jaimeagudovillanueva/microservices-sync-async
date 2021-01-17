package es.jaime.users.controller;

import es.jaime.users.model.entity.User;
import es.jaime.users.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.findById(userId);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user, @PathVariable String userId) {
        return userService.update(user, userId);
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId) {
        userService.delete(userId);
    }
}

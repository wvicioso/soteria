package api.rendezvous.controller;

import api.rendezvous.exception.UserNotFoundException;
import api.rendezvous.models.School;
import api.rendezvous.models.User;
import api.rendezvous.service.SchoolService;
import api.rendezvous.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolService schoolService;        //to validate that the school exists

    @GetMapping
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/{user_id}")
    public Optional<User> getUserById(@PathVariable("user_id") long user_id) {
        return userService.getUserById(user_id);
    }

    @DeleteMapping(value = "/{user_id}")
    public void deleteUserById(@PathVariable("user_id") long user_id) {
        this.userService.deleteUserById(user_id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user) {
        this.userService.insertUser(user);
    }

    @GetMapping(value = "/school/{school}")
    public Collection<User> getUserBySchool(@PathVariable("school") long id) {
        return this.userService.getUserBySchool(id);
    }
}

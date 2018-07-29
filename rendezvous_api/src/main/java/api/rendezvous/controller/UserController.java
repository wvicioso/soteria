package api.rendezvous.controller;

import api.rendezvous.models.User;
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

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable("user_id") long user_id) {
        return this.userService.getUserById(user_id);
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("user_id") long user_id) {
        this.userService.deleteUserById(user_id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user) {
        this.userService.insertUser(user);
    }

    @RequestMapping(value = "/school/{school}", method = RequestMethod.GET)
    public void getUserByAddress(@PathVariable("school") long id) {
        this.userService.getUserBySchool(id);
    }
}

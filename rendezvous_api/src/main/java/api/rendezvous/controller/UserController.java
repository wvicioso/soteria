package api.rendezvous.controller;

import api.rendezvous.exception.UserNotFoundException;
import api.rendezvous.models.School;
import api.rendezvous.models.User;
import api.rendezvous.service.SchoolService;
import api.rendezvous.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.MediaTypes;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/{user_id}", produces = MediaTypes.HAL_JSON_VALUE)
    public Resource<User> getUserById(@PathVariable("user_id") long user_id) {

        Optional<User> user = validateUser(user_id);
        Resource<User> resource = new Resource<User>(user.get());
        return resource;

    }

    @DeleteMapping(value = "/{user_id}")
    public void deleteUserById(@PathVariable("user_id") long user_id) {
        this.userService.deleteUserById(user_id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user) {
        validateUser(user.getUserId());
        this.userService.updateUser(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user) {
        validateUserDoesNotExist(user.getUserId());
        this.userService.insertUser(user);
    }

    @GetMapping(value = "/school/{school}", produces = MediaTypes.HAL_JSON_VALUE)
    public Resources<Resource<User>> getUserBySchool(@PathVariable("school") long id) {

        //need to run a validate school
        validateSchool(id);
        Collection<User> users = this.userService.getUserBySchool(id);
        return new Resources<>(this.userService.getUserBySchool(id)
                                                    .stream()
                                                    .map(bookmark -> toResource(bookmark))
                                                    .collect(Collectors.toList()));
    }


    private Optional<User> validateUserDoesNotExist(long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent())
            throw new UserNotFoundException("User id=" + id + " already exists");
        return user;
    }

    private Optional<User> validateUser(long id) {
        Optional<User> user = userService.getUserById(id);
        if (!user.isPresent())
            throw new UserNotFoundException("User id=" + id + " does not exist");
        return user;
    }

    private Optional<School> validateSchool(long id) {
        Optional<School> school = schoolService.getSchoolById(id);
        if (!school.isPresent())
            throw new UserNotFoundException("School id=" + id + " does not exist");
        return school;
    }

    private static Resource<User> toResource(User bookmark) {
        return new Resource(bookmark);
}
}

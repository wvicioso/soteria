package api.rendezvous.controller;

import api.rendezvous.exception.UserNotFoundException;
import api.rendezvous.models.User;
import api.rendezvous.service.EmailService;
import api.rendezvous.service.UserService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmailService emailService;

    @GetMapping
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/{user_id}")
    public Optional<User> getUserById(@PathVariable("user_id") long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) {

        Optional<User> user_holder = userService.findByEmail(user.getEmail());

        if (user_holder.isPresent()) {
            throw new UserNotFoundException("User id=" + user.getEmail() + " already exists. Cannot insert into DB");
        } else {
            user.setEnabled(false);
            user.setConfirmationToken(UUID.randomUUID().toString());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            this.userService.createUser(user);

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("To confirm your e-mail address, please enter the following information into the app" +
                    "\nconfirmation token = " + user.getConfirmationToken());
            registrationEmail.setFrom("noreply@domain.com");
            emailService.sendEmail(registrationEmail);
        }
    }

    // Process confirmation link
    // http://localhost:8080/users/validate?token=<space_holder>
    @PostMapping(value = "validate")
    public void showConfirmationPage(@RequestParam(value="token") String token) {

        User user = userService.findByConfirmationToken(token);
        if (user == null) { // No token found in DB
            throw new UserNotFoundException("User id=" + user.getEmail() + " does not exist. Can not confirm ID");
        } else { // Token found
            user.setEnabled(true);
            user.setConfirmationToken(null);
            userService.saveUser(user);
        }
    }
}

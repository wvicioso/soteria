package api.rendezvous.service;

import api.rendezvous.exception.UserNotFoundException;
import api.rendezvous.repository.UserRepository;
import api.rendezvous.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    @Qualifier("MySql")
    private UserRepository userRepository;

    public Collection<User> getAllUsers() {
        return (Collection<User>) this.userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User id=" + id + " does not exist");
        }
        return user;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}

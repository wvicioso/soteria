package api.rendezvous.service;

import api.rendezvous.daolayer.UserRepository;
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
    private UserRepository userdao;

    public Collection<User> getAllUsers() {
        return (Collection<User>) this.userdao.findAll();
    }

    public Optional<User> getUserById(long user_id) {
        //do a check to see if user actually exists.
        //if so return the value else return an error code
        return this.userdao.findById(user_id);
    }

    public void deleteUserById(long user_id) {
        this.userdao.deleteById(user_id);
    }

    public void updateUser(User user) { this.userdao.save(user);
    }

    public void insertUser(User user) {
        this.userdao.save(user);
    }
}

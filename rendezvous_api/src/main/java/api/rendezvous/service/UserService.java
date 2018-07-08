package api.rendezvous.service;

import api.rendezvous.daolayer.UserDB;
import api.rendezvous.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    @Qualifier("FakeData")
    private UserDB userdao;

    public Collection<User> getAllUsers() {
        return this.userdao.getAllUsers();
    }

    public User getUserById(long user_id) {
        //do a check to see if user actually exists.
        //if so return the value else return an error code
        return this.userdao.getUserById(user_id);
    }

    public void deleteUserById(long user_id) {
        this.userdao.deleteUserById(user_id);
    }

    public void updateUser(User user) {
        this.userdao.updateUser(user);
    }

    public void insertUser(User user) {
        this.userdao.insertUserToDb(user);
    }
}

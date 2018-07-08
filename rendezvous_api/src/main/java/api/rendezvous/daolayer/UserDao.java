package api.rendezvous.daolayer;

import api.rendezvous.models.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUsers();

    User getUserById(long user_id);

    void deleteUserById(long user_id);

    void updateUser(User user);

    void insertUserToDb(User user);
}

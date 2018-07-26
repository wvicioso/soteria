package api.rendezvous.repository;

import api.rendezvous.models.User;

import java.util.Collection;

public interface UserDao {

    Collection<User> findAll();

    User findById(long user_id);

    void deleteById(long user_id);

    void save(User user);

}

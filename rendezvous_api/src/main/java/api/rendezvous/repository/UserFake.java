package api.rendezvous.repository;

import api.rendezvous.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

@Repository
@Qualifier("FakeData")
public class UserFake implements UserDao {

    private static Map<Long, User> users;

    static {
        users = new HashMap<Long, User>() {
            {
                User welly = new User("letemhang", "Wellington", "Viscosio", "wviscosio@baruch.com", 1L);
                User satty = new User("eminem", "Satya", "Gupta", "satya@citymail.com", 2L);
                put(welly.getUser_id(), welly);
                put(satty.getUser_id(), satty);
            }
        };
    }

    @Override
    public Collection<User> findAll() {
        return this.users.values();
    }

    @Override
    public User findById(long user_id) {
        return this.users.get(user_id);
    }

    @Override
    public void deleteById(long user_id) {
        users.remove(user_id);
    }

    @Override
    public void save(User user) {
        users.put(user.getUser_id(), user);
    }
}

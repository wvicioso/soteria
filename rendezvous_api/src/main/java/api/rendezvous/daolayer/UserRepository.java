package api.rendezvous.daolayer;

import api.rendezvous.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("MySql")
public interface UserRepository extends CrudRepository  <User, Long> {

        }
//public class UserRepository implements UserDaoInterface {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public Collection<User> getAllUsers() {
//        return null;
//    }
//
//    @Override
//    public User getUserById(long user_id) {
//        return getCurrentSession().find(User.class, user_id);
//    }
//
//    @Override
//    public void deleteUserById(long user_id) {
//        User user = findUser(user_id);
//        getCurrentSession().delete(user_id);
//    }
//
//    public User findUser(long id) {
//        return getCurrentSession().find(User.class, 1);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        getCurrentSession().merge(user);
//    }
//
//    @Override
//    public void insertUserToDb(User user) {
//        getCurrentSession().persist(user);
//    }
//
//    protected Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }
//}

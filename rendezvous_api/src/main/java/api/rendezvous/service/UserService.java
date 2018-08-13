package api.rendezvous.service;

import api.rendezvous.exception.UserNotFoundException;
import api.rendezvous.models.School;
import api.rendezvous.repository.SchoolRepository;
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
    private UserRepository userrepository;

    @Autowired
    @Qualifier("MySql")
    private SchoolRepository schoolrepository;

    public Collection<User> getAllUsers() {
        return (Collection<User>) this.userrepository.findAll();
    }

    public Optional<User> getUserById(long user_id) {
        Optional<User> user = validateUser(user_id);
        return user;
    }

    public void deleteUserById(long user_id) {
        Optional<User> user = validateUser(user_id);
        if(user.isPresent()) {
            this.userrepository.deleteById(user_id);
        }
    }

    public void updateUser(User user) {
        boolean exists = validateUser(user.getUserId()).isPresent();
        if(exists) {
            this.userrepository.save(user);
        }
    }
    public void insertUser(User user) {
        validateUserDoesNotExist(user.getUserId());
        this.userrepository.save(user);
    }

    public Collection<User> getUserBySchool(long id) {
        validateSchool(id);
        return this.userrepository.findBySchoolId(id);
    }

    private Optional<User> validateUser(long id) {
        Optional<User> user = userrepository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException("User id=" + id + " does not exist");
        return user;
    }

    private void validateUserDoesNotExist(long id) {
        Optional<User> user = userrepository.findById(id);
        if (user.isPresent())
            throw new UserNotFoundException("User id=" + id + " already exists. Cannot insert into DB");

    }

    private Optional<School> validateSchool(long id) {
        Optional<School> school = schoolrepository.findById(id);
        if (!school.isPresent())
            throw new UserNotFoundException("School id=" + id + " does not exist");
        return school;
    }
}

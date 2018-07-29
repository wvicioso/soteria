package api.rendezvous.repository;

import api.rendezvous.models.School;
import api.rendezvous.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("MySql")
public interface UserRepository extends JpaRepository  <User, Long> {

    public List<User> findBySchoolId(long id);
}


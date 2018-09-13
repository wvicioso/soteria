package api.rendezvous.repository;

import api.rendezvous.models.School;
import api.rendezvous.models.User;
import api.rendezvous.models.UserDef;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("MySql")
public interface UserRepository extends JpaRepository  <User, Long> {

    /*This is only needed if you need to tweak transaction
    configuration for one of the methods declared in a repository,*/

//    @Transactional(readOnly=true, timeout=10)         /*If you only want to perform a read operation*/

//    @Modifying                            /* Used in conjuction to allow edits
//    @Transactional

//    @Query(value = "Select u from User u where u.school.id = :id", nativeQuery = false)
//    public Collection<UserDef> findBySchoolId(@Param("id") long id);
//
//    @Query("Select u from User u where u.id = :id")
//    public Optional<UserDef> findByPartialId(@Param("id") long id);

    public Optional<User> findByEmail(String email);
    public User findByConfirmationToken(String confirmationToken);
}


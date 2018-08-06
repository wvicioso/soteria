package api.rendezvous.repository;

import api.rendezvous.models.School;
import api.rendezvous.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("MySql")
public interface UserRepository extends JpaRepository  <User, Long> {

    /*This is only needed if you need to tweak transaction
    configuration for one of the methods declared in a repository,*/

//    @Transactional(readOnly=true, timeout=10)         /*If you only want to perform a read operation*/

//    @Modifying                            /* Used in conjuction to allow edits
//    @Transactional

//    @Query("delete from User u where u.active = false")       /*if you want to customize the SQL query to perform*/
    public Collection<User> findBySchoolId(long id);
}


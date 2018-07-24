package api.rendezvous.daolayer;

import api.rendezvous.models.School;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FakeData")
public class SchoolFake implements SchoolDaoInterface {

    private static Map<Long, School> schools;

    static {
        schools = new HashMap<Long, School>() {
            {
                put(1L, new School("55 Lexington Ave, New York, NY 10010", "Baruch", "@baruchmail.cuny.edu", 40.7402, 73.9834));
                put(2L, new School("160 Convent Ave, New York, NY 10031", "City College", "@citymail.cuny.edu", 40.8200, 73.94930));
            }
        };
    }

    @Override
    public Collection<School> getAllSchools() {
        return this.schools.values();
    }

    @Override
    public School getSchoolById(long school_id) {
        return this.schools.get(school_id);
    }
}

package api.rendezvous.daolayer;

import api.rendezvous.models.School;

import java.util.Collection;

public interface SchoolDao {
    Collection<School> getAllSchools();

    School getSchoolById(long school_id);
}

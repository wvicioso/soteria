package api.rendezvous.daolayer;

import api.rendezvous.models.School;

import java.util.Collection;

public interface SchoolDaoInterface {
    Collection<School> getAllSchools();

    School getSchoolById(long school_id);
}

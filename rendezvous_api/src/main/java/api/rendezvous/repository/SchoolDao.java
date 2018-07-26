package api.rendezvous.repository;

import api.rendezvous.models.School;

import java.util.Collection;

public interface SchoolDao {
    Collection<School> findAll();

    School findById(long school_id);
}

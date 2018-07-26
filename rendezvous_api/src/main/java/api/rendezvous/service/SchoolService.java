package api.rendezvous.service;

import api.rendezvous.models.School;
import api.rendezvous.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SchoolService {

//    @Autowired
//    private SchoolFake schoolrepository;

    @Autowired
    private SchoolRepository schoolrepository;

    public Collection<School> getAllSchools() {
        return this.schoolrepository.findAll();
    }

    public Optional<School> getSchoolById(long school_id) {
        return this.schoolrepository.findById(school_id);
    }
}

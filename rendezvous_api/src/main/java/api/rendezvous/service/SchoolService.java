package api.rendezvous.service;

import api.rendezvous.daolayer.SchoolFake;
import api.rendezvous.models.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SchoolService {

    @Autowired
    private SchoolFake schooldao;

    public Collection<School> getAllSchools() {
        return this.schooldao.getAllSchools();
    }

    public School getSchoolById(long school_id) {
        return this.schooldao.getSchoolById(school_id);
    }
}

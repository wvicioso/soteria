package api.rendezvous.controller;

import api.rendezvous.models.School;
import api.rendezvous.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolservice;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<School> getAllSchools() {
        return this.schoolservice.getAllSchools();
    }

    @RequestMapping(value = "/{school_id}", method = RequestMethod.GET)
    public School getSchoolById(@PathVariable long school_id) {
        return this.schoolservice.getSchoolById(school_id);
    }

}

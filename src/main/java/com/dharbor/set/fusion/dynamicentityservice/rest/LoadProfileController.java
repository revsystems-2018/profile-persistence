package com.dharbor.set.fusion.dynamicentityservice.rest;

import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.service.LoadProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rveizaga
 */
@RestController
public class LoadProfileController {

    @Autowired
    private LoadProfileService service;

    @RequestMapping(
            value = "/profiles",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = service.findAllProfiles();

        return ResponseEntity.ok(profiles);
    }
}

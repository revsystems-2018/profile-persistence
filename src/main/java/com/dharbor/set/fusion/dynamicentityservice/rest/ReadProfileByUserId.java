package com.dharbor.set.fusion.dynamicentityservice.rest;

import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.service.ReadProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rveizaga
 */
@RestController
public class ReadProfileByUserId {

    @Autowired
    private ReadProfileService service;

    @RequestMapping(
            value = "/profiles/users/{userId}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Profile> getProfileByUserId(@PathVariable("userId") String userId) {
        Profile profiles = service.findByUserId(userId);

        return ResponseEntity.ok(profiles);
    }
}

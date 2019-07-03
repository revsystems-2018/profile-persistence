package com.dharbor.set.fusion.dynamicentityservice.rest;

import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.dto.ProfileDTO;
import com.dharbor.set.fusion.dynamicentityservice.service.CreateProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rveizaga
 */
@RestController
public class CreateProfileController {

    @Autowired
    private CreateProfileService service;

    @RequestMapping(
            value = "/profiles",
            method = RequestMethod.POST
    )
    public ResponseEntity<Profile> createProfile(@RequestBody CreateProfileRequest request) {
        ProfileDTO profileDTO = new Profile();
        profileDTO.setUserId(request.getUserId());
        profileDTO.setFirstName(request.getFirstName());
        profileDTO.setLastName(request.getLastName());
        profileDTO.setEmail(request.getEmail());

        Profile profile = service.createProfile(profileDTO, request.getDmsDocument());

        return ResponseEntity.ok(profile);
    }

    private static class CreateProfileRequest {
        private String userId;

        private String email;

        private String firstName;

        private String lastName;

        private DMSDocument dmsDocument;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public DMSDocument getDmsDocument() {
            return dmsDocument;
        }

        public void setDmsDocument(DMSDocument dmsDocument) {
            this.dmsDocument = dmsDocument;
        }
    }
}

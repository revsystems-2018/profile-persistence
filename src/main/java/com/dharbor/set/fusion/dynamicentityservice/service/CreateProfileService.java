package com.dharbor.set.fusion.dynamicentityservice.service;

import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.dto.ProfileDTO;
import com.dharbor.set.fusion.dynamicentityservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author rveizaga
 */
@Service
public class CreateProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(ProfileDTO profileDTO, DMSDocument dmsDocument) {
        Profile profileDB;
        Profile profile = profileRepository.findByUserId(profileDTO.getUserId());

        if (null == profile) {
            profileDB = profileRepository.insert(buildProfileToSave(profileDTO, dmsDocument));

        } else {
            profile.setDmsId(dmsDocument.getDmsId());
            profileDB = profileRepository.save(profile);
        }

        return profileDB;
    }

    private Profile buildProfileToSave(ProfileDTO profileDTO, DMSDocument dmsDocument) {
        Profile profile = new Profile();
        profile.setUserId(profileDTO.getUserId());
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setEmail(profileDTO.getEmail());
        profile.setDmsId(dmsDocument.getDmsId());
        profile.setCreatedDate(new Date());

        return profile;
    }
}

package com.dharbor.set.fusion.dynamicentityservice.service;

import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rveizaga
 */
@Service
public class LoadProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAllProfiles() {
        return profileRepository.findAll();
    }
}

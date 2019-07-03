package com.dharbor.set.fusion.dynamicentityservice.service;

import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rveizaga
 */
@Service
public class ReadProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile findByUserId(String userId) {
        return profileRepository.findByUserId(userId);
    }
}

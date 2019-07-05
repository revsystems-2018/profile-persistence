package com.dharbor.set.fusion.dynamicentityservice.service.userprofile;

import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rveizaga
 */
@Service
public class CreateUPSProfileService {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfileResponse createUserProfile(String nameProfile) {
        return userProfileService.createUserProfile(nameProfile);
    }
}

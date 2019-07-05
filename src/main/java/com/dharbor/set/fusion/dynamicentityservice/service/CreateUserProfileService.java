package com.dharbor.set.fusion.dynamicentityservice.service;

import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileRequest;
import com.dharbor.set.fusion.dynamicentityservice.model.UserProfile;
import com.dharbor.set.fusion.dynamicentityservice.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rveizaga
 */
@Service
public class CreateUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfileRequest userProfile) {

        return userProfileRepository.save(buildUserProfile(userProfile));
    }

    private UserProfile buildUserProfile(UserProfileRequest request) {
        UserProfile response = new UserProfile();
        response.setUpsProfile(request.getUpsProfile());
        response.setUpsSections(request.getUpsSections());

        return response;
    }
}

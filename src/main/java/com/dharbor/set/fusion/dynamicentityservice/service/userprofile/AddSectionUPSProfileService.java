package com.dharbor.set.fusion.dynamicentityservice.service.userprofile;

import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rveizaga
 */
@Service
public class AddSectionUPSProfileService {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfileRequest addSectionUserProfile(Long profileId, Long sectionId) {
        return userProfileService.addSectionsUserProfile(profileId, sectionId);
    }
}

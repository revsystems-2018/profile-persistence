package com.dharbor.set.fusion.dynamicentityservice.service.userprofile;

import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rveizaga
 */
@Service
public class LoadUPSProfilesService {

    @Autowired
    private UserProfileService userProfileService;

    public List<UserProfileResponse> loadUserProfiles() {
        return userProfileService.getProfiles();
    }
}

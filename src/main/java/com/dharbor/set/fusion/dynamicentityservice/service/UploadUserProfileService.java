package com.dharbor.set.fusion.dynamicentityservice.service;

import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileRequest;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import com.dharbor.set.fusion.dynamicentityservice.dto.ProfileDTO;
import com.dharbor.set.fusion.dynamicentityservice.model.Profile;
import com.dharbor.set.fusion.dynamicentityservice.model.User;
import com.dharbor.set.fusion.dynamicentityservice.model.UserProfile;
import com.dharbor.set.fusion.dynamicentityservice.service.security.FindUserService;
import com.dharbor.set.fusion.dynamicentityservice.service.userprofile.AddSectionUPSProfileService;
import com.dharbor.set.fusion.dynamicentityservice.service.userprofile.CreateUPSProfileService;
import com.dharbor.set.fusion.dynamicentityservice.service.userprofile.LoadUPSProfilesService;
import com.dharbor.set.fusion.dynamicentityservice.service.userprofile.UploadUPSProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author rveizaga
 */
@Service
public class UploadUserProfileService {

    private static final Long SECTION_ID = 1L;
    private static final Long ATTRIBUTE_ID = 3L;

    @Autowired
    private LoadUPSProfilesService loadUPSProfilesService;

    @Autowired
    private CreateUPSProfileService createUPSProfileService;

    @Autowired
    private AddSectionUPSProfileService addSectionUPSProfileService;

    @Autowired
    private UploadUPSProfileService uploadUPSProfileService;

    @Autowired
    private FindUserService findUserService;

    @Autowired
    private CreateUserProfileService createUserProfileService;

    @Autowired
    private CreateProfileService createProfileService;

    public Profile UploadPictureProfile(String userId, MultipartFile file) {
        Profile profile;
        String nameProfile = userId;

        User user = findUserService.findUserById(userId);

        if (null != user) {
            nameProfile = user.getFirstName() + " " + user.getLastName();
        }

        UserProfileResponse profileResponse = getUserProfile(nameProfile);
        if (null == profileResponse) {
            profileResponse = createUPSProfileService.createUserProfile(nameProfile);

            UserProfileRequest profileRequest = addSectionUPSProfileService.addSectionUserProfile(
                    profileResponse.getId(),
                    SECTION_ID);
            UserProfile userProfile = createUserProfileService.createUserProfile(profileRequest);
        }

        DMSDocument dmsDocument = uploadUPSProfileService.uploadUserProfile(
                userId,
                profileResponse.getId(),
                SECTION_ID,
                ATTRIBUTE_ID,
                file);

        return createProfileService.createProfile(buildProfileDTO(user), dmsDocument);
    }

    private ProfileDTO buildProfileDTO(User user) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setUserId(user.getId());
        profileDTO.setFirstName(user.getFirstName());
        profileDTO.setLastName(user.getLastName());
        profileDTO.setEmail(user.getEmail());

        return profileDTO;
    }

    private UserProfileResponse getUserProfile(String name) {
        List<UserProfileResponse> profiles = loadUPSProfilesService.loadUserProfiles();

        for (UserProfileResponse profile : profiles) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }
}

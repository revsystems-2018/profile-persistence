package com.dharbor.set.fusion.dynamicentityservice.service.userprofile;

import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author rveizaga
 */
@Service
public class UploadUPSProfileService {

    @Autowired
    private UserProfileService userProfileService;

    public DMSDocument uploadUserProfile(String userId,
                                         Long profileId,
                                         Long sectionId,
                                         Long attributeId,
                                         MultipartFile file) {

        return userProfileService.uploadPictureUserProfile(userId, profileId, sectionId, attributeId, file);
    }
}

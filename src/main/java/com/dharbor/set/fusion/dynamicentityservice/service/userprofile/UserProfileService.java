package com.dharbor.set.fusion.dynamicentityservice.service.userprofile;

import com.dharbor.set.fusion.dynamicentityservice.command.AddSectionsUserProfileCmd;
import com.dharbor.set.fusion.dynamicentityservice.command.CreateUserProfileCmd;
import com.dharbor.set.fusion.dynamicentityservice.command.LoadUserProfilesCmd;
import com.dharbor.set.fusion.dynamicentityservice.command.UploadPictureUserProfileCmd;
import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileRequest;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import com.dharbor.set.fusion.dynamicentityservice.exception.EntityNotFoundException;
import com.dharbor.set.fusion.dynamicentityservice.service.AbstractCommandService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author rveizaga
 */
@Service
public class UserProfileService extends AbstractCommandService {

    public List<UserProfileResponse> getProfiles() {
        LoadUserProfilesCmd command = createCommand(LoadUserProfilesCmd.class);
        command.execute();

        return command.getProfiles();
    }

    public UserProfileResponse createUserProfile(String name) {
        try {
            CreateUserProfileCmd command = createCommand(CreateUserProfileCmd.class);
            command.setName(name);
            command.execute();

            return command.getResponse();

        } catch (EntityNotFoundException e) {
            throw new UnsupportedOperationException("Unable to process payload to class " + name);
        }
    }

    public UserProfileRequest addSectionsUserProfile(Long profileId, Long sectionId) {
        AddSectionsUserProfileCmd command = createCommand(AddSectionsUserProfileCmd.class);
        command.setProfileId(profileId);
        command.setSectionId(sectionId);
        command.execute();

        return command.getRequest();
    }

    public DMSDocument uploadPictureUserProfile(String userId,
                                                Long profileId,
                                                Long sectionId,
                                                Long attributeId,
                                                MultipartFile file) {
        UploadPictureUserProfileCmd command = createCommand(UploadPictureUserProfileCmd.class);
        command.setUserId(userId);
        command.setProfileId(profileId);
        command.setSectionId(sectionId);
        command.setAttributeNameId(attributeId);
        command.setFile(file);
        command.execute();

        return command.getDmsDocument();
    }
}

package com.dharbor.set.fusion.dynamicentityservice.command;

import com.dharbor.set.fusion.dynamicentityservice.api.UserProfileClient;
import com.dharbor.set.fusion.dynamicentityservice.domain.DMSDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author rveizaga
 */
@Component
@Scope("prototype")
public class UploadPictureUserProfileCmd extends AbstractCommand {

    private String userId;

    private Long profileId;

    private Long sectionId;

    private Long attributeNameId;

    private MultipartFile file;

    private DMSDocument dmsDocument;

    @Autowired
    private UserProfileClient client;

    @Override
    protected void onExecute() {
        dmsDocument = client.uploadPictureUserProfile(userId, profileId, sectionId, attributeNameId, file);
    }

    public DMSDocument getDmsDocument() {
        return dmsDocument;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public void setAttributeNameId(Long attributeNameId) {
        this.attributeNameId = attributeNameId;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

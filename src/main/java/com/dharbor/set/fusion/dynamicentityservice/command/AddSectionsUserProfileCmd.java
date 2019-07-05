package com.dharbor.set.fusion.dynamicentityservice.command;

import com.dharbor.set.fusion.dynamicentityservice.api.UserProfileClient;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rveizaga
 */
@Component
@Scope("prototype")
public class AddSectionsUserProfileCmd extends AbstractCommand {

    private Long profileId;

    private Long sectionId;

    private UserProfileRequest request;

    @Autowired
    private UserProfileClient client;

    @Override
    protected void onExecute() {
        List<Long> sectionIds = new ArrayList<>();
        sectionIds.add(sectionId);

        request = client.AddSectionsToProfile(profileId, sectionIds);
    }

    public UserProfileRequest getRequest() {
        return request;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}

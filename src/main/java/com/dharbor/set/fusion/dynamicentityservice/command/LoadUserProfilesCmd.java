package com.dharbor.set.fusion.dynamicentityservice.command;

import com.dharbor.set.fusion.dynamicentityservice.api.UserProfileClient;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rveizaga
 */
@Component
@Scope("prototype")
public class LoadUserProfilesCmd extends AbstractCommand {

    private List<UserProfileResponse> profiles;

    @Autowired
    private UserProfileClient client;

    @Override
    protected void onExecute() {
        profiles = client.findAllProfiles();
    }

    public List<UserProfileResponse> getProfiles() {
        return profiles;
    }
}

package com.dharbor.set.fusion.dynamicentityservice.command;

import com.dharbor.set.fusion.dynamicentityservice.api.UserProfileClient;
import com.dharbor.set.fusion.dynamicentityservice.domain.UserProfileResponse;
import com.dharbor.set.fusion.dynamicentityservice.dto.UPSUserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author rveizaga
 */
@Component
@Scope("prototype")
public class CreateUserProfileCmd extends AbstractCommand {

    private String name;

    private UserProfileResponse response;

    @Autowired
    private UserProfileClient client;

    @Override
    protected void onExecute() {
        UPSUserProfileDTO dto = new UPSUserProfileDTO();
        dto.setName(name);

        response = client.createProfile(dto);
    }

    public UserProfileResponse getResponse() {
        return response;
    }

    public void setName(String name) {
        this.name = name;
    }
}

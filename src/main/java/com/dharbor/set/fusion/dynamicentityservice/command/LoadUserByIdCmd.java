package com.dharbor.set.fusion.dynamicentityservice.command;

import com.dharbor.set.fusion.dynamicentityservice.api.FindUserByIdClient;
import com.dharbor.set.fusion.dynamicentityservice.config.DataPropertiesConfig;
import com.dharbor.set.fusion.dynamicentityservice.domain.converter.ObjectContentConverter;
import com.dharbor.set.fusion.dynamicentityservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author rvasquez
 */
@Component
@Scope("prototype")
public class LoadUserByIdCmd extends AbstractCommand {

    private String userId;

    private User user;

    private Object userForeign;

    @Autowired
    private DataPropertiesConfig dataPropertiesConfig;

    @Autowired
    private FindUserByIdClient userClient;

    @Override
    protected void onExecute() {
        userForeign = userClient.findById(userId);
        convertAttributesUser();
    }

    private void convertAttributesUser() {
        Map<String, String> mapAttributes = dataPropertiesConfig.getUser();

        user = ObjectContentConverter.buildObjectToUser(userForeign, mapAttributes);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }
}

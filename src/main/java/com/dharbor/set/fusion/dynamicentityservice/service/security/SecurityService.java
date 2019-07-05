package com.dharbor.set.fusion.dynamicentityservice.service.security;

import com.dharbor.set.fusion.dynamicentityservice.command.LoadUserByIdCmd;
import com.dharbor.set.fusion.dynamicentityservice.exception.EntityNotFoundException;
import com.dharbor.set.fusion.dynamicentityservice.model.User;
import com.dharbor.set.fusion.dynamicentityservice.service.AbstractCommandService;
import org.springframework.stereotype.Service;

/**
 * @author rveizaga
 */
@Service
public class SecurityService extends AbstractCommandService {

    public User findUserById(String userId) {
        try {

            LoadUserByIdCmd command = createCommand(LoadUserByIdCmd.class);
            command.setUserId(userId);
            command.execute();

            return command.getUser();

        } catch (EntityNotFoundException e) {
            throw new UnsupportedOperationException("Unable to process payload to class " + userId);
        }
    }
}

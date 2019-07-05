package com.dharbor.set.fusion.dynamicentityservice.service.security;

import com.dharbor.set.fusion.dynamicentityservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rveizaga
 */
@Service
public class FindUserService {

    @Autowired
    private SecurityService userService;

    public User findUserById(String userId) {
        return userService.findUserById(userId);
    }

}

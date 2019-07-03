package com.dharbor.set.fusion.dynamicentityservice.domain.converter;

import com.dharbor.set.fusion.dynamicentityservice.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author rveizaga
 */
public class ObjectContentConverter {

    private static final String USER_ID = "id";
    private static final String EMAIL = "email";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    public static User buildObjectToUser(Object object, Map<String, String> mapAttributes) {
        ObjectMapper oMapper = new ObjectMapper();
        Map userMap = oMapper.convertValue(object, Map.class);

        String id = (userMap.get(mapAttributes.get(USER_ID))).toString();
        String firstName = (userMap.get(mapAttributes.get(FIRST_NAME))).toString();
        String lastName = (userMap.get(mapAttributes.get(LAST_NAME))).toString();
        String email = (userMap.get(mapAttributes.get(EMAIL))).toString();

        User userCurrent = new User();
        userCurrent.setId(id);
        userCurrent.setEmail(email);
        userCurrent.setFirstName(firstName);
        userCurrent.setLastName(lastName);

        return userCurrent;
    }
}

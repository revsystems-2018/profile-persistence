package com.dharbor.set.fusion.dynamicentityservice.api;

/**
 * @author rveizaga
 */
public final class ApiConstants {

    private static final String ACTION = "Utility class";

    private ApiConstants() {
        throw new IllegalStateException(ACTION);
    }

    public static class UserProfileService {
        public UserProfileService() {
            throw new IllegalStateException(ACTION);
        }

        public static final String NAME_KEY = "${userProfile.service.name}";
        public static final String URL_KEY = "${userProfile.service.url}";
    }

    public static class SecurityService {
        public SecurityService() {
            throw new IllegalStateException(ACTION);
        }

        public static final String NAME_KEY = "${persistence.name}";
        public static final String URL_KEY = "${persistence.api.login.url}";
        public static final String URL_USER_BY_ID = "${persistence.api.findById.url}";
    }
}

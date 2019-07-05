package com.dharbor.set.fusion.dynamicentityservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author rveizaga
 */
public class UserProfileRequest {

    @JsonProperty("profile")
    private UPSProfile upsProfile;

    @JsonProperty("sections")
    private List<UPSSection> upsSections;

    public UPSProfile getUpsProfile() {
        return upsProfile;
    }

    public void setUpsProfile(UPSProfile upsProfile) {
        this.upsProfile = upsProfile;
    }

    public List<UPSSection> getUpsSections() {
        return upsSections;
    }

    public void setUpsSections(List<UPSSection> upsSections) {
        this.upsSections = upsSections;
    }
}

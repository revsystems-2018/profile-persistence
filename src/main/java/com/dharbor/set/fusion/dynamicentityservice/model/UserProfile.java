package com.dharbor.set.fusion.dynamicentityservice.model;

import com.dharbor.set.fusion.dynamicentityservice.domain.UPSProfile;
import com.dharbor.set.fusion.dynamicentityservice.domain.UPSSection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author rveizaga
 */
public class UserProfile {

    @Id
    private String id;

    @JsonProperty("profile")
    private UPSProfile upsProfile;

    @JsonProperty("sections")
    private List<UPSSection> upsSections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

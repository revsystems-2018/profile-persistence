package com.dharbor.set.fusion.dynamicentityservice.domain;

import java.util.Collection;
import java.util.List;

/**
 * @author rveizaga
 */
public class Section {

    private Long id;

    private String name;

    private Collection<Profile> profiles;

    private List<AttributeName> attributeNames;

    private Subscription subscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Collection<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<AttributeName> getAttributeNames() {
        return attributeNames;
    }

    public void setAttributeNames(List<AttributeName> attributeNames) {
        this.attributeNames = attributeNames;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}

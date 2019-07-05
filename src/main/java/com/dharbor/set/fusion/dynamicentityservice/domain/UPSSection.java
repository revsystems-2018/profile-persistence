package com.dharbor.set.fusion.dynamicentityservice.domain;

import java.util.List;

/**
 * @author rveizaga
 */
public class UPSSection {

    private Long id;

    private String name;

    private List<UPSAttributeName> attributeNames;

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

    public List<UPSAttributeName> getAttributeNames() {
        return attributeNames;
    }

    public void setAttributeNames(List<UPSAttributeName> attributeNames) {
        this.attributeNames = attributeNames;
    }
}

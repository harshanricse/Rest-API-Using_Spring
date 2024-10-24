package com.infytel.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement
@XmlSeeAlso({PlanDTO.class})
public class EntityListPlan<T> {

 private List<T> listOfEntityObjects;

    public EntityListPlan() {
        listOfEntityObjects = new ArrayList<>();
    }

    public EntityListPlan(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems()
    {
        return listOfEntityObjects;
    }
}
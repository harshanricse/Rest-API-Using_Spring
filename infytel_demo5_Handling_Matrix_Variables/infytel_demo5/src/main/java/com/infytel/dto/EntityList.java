package com.infytel.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;


//Annotation that is required to serialize data in XML format
@XmlRootElement
@XmlSeeAlso({PlanDTO.class})
public class EntityList<T> {

 private List<T> listOfEntityObjects;

    public EntityList() {
        listOfEntityObjects = new ArrayList<>();
    }

    public EntityList(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

  @XmlAnyElement
    public List<T> getItems()
    {
        return listOfEntityObjects;
    }
}
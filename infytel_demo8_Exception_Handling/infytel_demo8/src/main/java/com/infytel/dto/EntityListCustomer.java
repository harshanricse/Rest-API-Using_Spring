package com.infytel.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement
@XmlSeeAlso({CustomerDTO.class})
public class EntityListCustomer<T> {

 private List<T> listOfEntityObjects;

    public EntityListCustomer() {
        listOfEntityObjects = new ArrayList<>();
    }

    public EntityListCustomer(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems()
    {
        return listOfEntityObjects;
    }
}
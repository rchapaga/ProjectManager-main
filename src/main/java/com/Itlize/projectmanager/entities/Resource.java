package com.Itlize.projectmanager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;


    @CreatedDate
    private Date timeCreate;

    @LastModifiedDate
    private Date lastUpdated;

    @JsonIgnore
    @OneToMany(targetEntity = Project_Resources.class, cascade = CascadeType.REMOVE, mappedBy = "resource")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Project_Resources> ProjectResources = new HashSet<>();

    @JsonIgnore
    @OneToMany(targetEntity = ResourceColumn.class,cascade = CascadeType.REMOVE, mappedBy = "resource")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ResourceColumn> resourceColumn = new HashSet<>();

    public Resource() {
    }

//    public Resource(Date timeCreate, Date lastUpdated, Set<ResourceDetails> resourcesDetails) {
//        //super();
//        this.timeCreate = timeCreate;
//        this.lastUpdated = lastUpdated;
//        this.resourcesDetails = resourcesDetails;
//    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer id) {
        this.resourceId = resourceId;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Resource [resourceId=" + resourceId + ", timeCreate=" + timeCreate + ", lastUpdated=" + lastUpdated + "]";
    }



}


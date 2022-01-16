package com.Itlize.projectmanager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="project")
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(name = "project_name")
    private String project_name;

    @CreatedDate
    private Date timeCreate;

    @ManyToOne(targetEntity = User.class)
    private User owner;

    @JsonIgnore
    @OneToMany(targetEntity = Project_Resources.class, cascade = CascadeType.REMOVE, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Project_Resources> projectResources = new HashSet<>();


    @JsonIgnore
    @OneToMany(targetEntity = ProjectDetails.class, cascade = CascadeType.REMOVE, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ProjectDetails> projectDetails = new HashSet<>();

    public Project() {
    }

//	public Project(Date timeCreate, User owner, Set<Project_Resources> resources) {
//		//super();
//		this.timeCreate = timeCreate;
//		this.owner = owner;
//		this.resources = resources;
//	}

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer id) {
        this.projectId = projectId;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Project_Resources> getResources() {
        return projectResources;
    }

    public void setResources(Set<Project_Resources> resources) {
        this.projectResources = projectResources;
    }

    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", timeCreate=" + timeCreate + ", owner=" + owner + ", projectResources=" + projectResources
                + "]";
    }



}

package com.Itlize.projectmanager.entities;


import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "project_resources")
@EntityListeners(AuditingEntityListener.class)
public class Project_Resources {


    @Id
    @GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity", strategy = "com.Itlize.projectmanager.entities.UseExistingIdOtherwiseGenerateUsingIdentity")
    @GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
    private Integer projectResourcesId;

    @Column(name = "firstName")
    private String firstName;



    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Project project;


    @ManyToOne(targetEntity = Resource.class, cascade = CascadeType.DETACH)
    private Resource resource;


    @CreatedDate
    private Date timeCreate;



    public Project_Resources() {
    }

//		public Project_Resources(Project project, Resource resource, Date timeCreate) {
//			//super();
//			this.project = project;
//			this.resource = resource;
//			this.timeCreate = timeCreate;
//		}


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Integer getProjectResourcesId() {
        return projectResourcesId;
    }

    public void setProjectResourcesId(Integer id) {
        this.projectResourcesId = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Override
    public String toString() {
        return "Project_Resources [projectResourcesId=" + projectResourcesId + ", project=" + project + ", resource=" + resource + ", timeCreate="
                + timeCreate + "]";
    }


}

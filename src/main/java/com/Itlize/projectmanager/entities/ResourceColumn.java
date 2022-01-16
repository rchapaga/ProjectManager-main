package com.Itlize.projectmanager.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="resource_column")
@EntityListeners(AuditingEntityListener.class)
public class ResourceColumn {

    @Id
    @GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity", strategy = "com.Itlize.projectmanager.entities.UseExistingIdOtherwiseGenerateUsingIdentity")
    @GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
    @Column( name = "resource_column_id",unique = true, nullable = false)
    private Integer resourceColumnId;

    @ManyToOne(targetEntity = ProjectDetails.class, cascade = CascadeType.DETACH)
    private ProjectDetails projectDetails;

    @ManyToOne(targetEntity = Resource.class, cascade = CascadeType.DETACH)
    private Resource resource;

    @Column(name = "detail_value")
    private String detailValue;

    @CreatedDate
    private Date timeCreate;

    @LastModifiedDate
    private Date lastUpdated;

    public ResourceColumn() {
    }

    public Integer getResourceColumnId() {
        return resourceColumnId;
    }

    public void setResourceColumnId(Integer id) {
        this.resourceColumnId = id;
    }

    public ProjectDetails getProject() {
        return projectDetails;
    }

    public void setProject(ProjectDetails project) {
        this.projectDetails = projectDetails;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getDetailValue() {
        return detailValue;
    }

    public void setDetailValue(String detailValue) {
        this.detailValue = detailValue;
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
        return "ResourceColumn{" +
                "resourceColumnId=" + resourceColumnId +
                ", projectDetails=" + projectDetails +
                ", resource=" + resource +
                ", detailValue='" + detailValue + '\'' +
                ", timeCreate=" + timeCreate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

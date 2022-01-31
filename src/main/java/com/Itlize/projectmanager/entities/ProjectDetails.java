package com.Itlize.projectmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="project_details")
@EntityListeners(AuditingEntityListener.class)
public class ProjectDetails {
    @Id
    @GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity", strategy = "com.Itlize.projectmanager.entities.UseExistingIdOtherwiseGenerateUsingIdentity")
    @GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
    private Integer projectDetailsId;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Project project;

    @JsonIgnore
    @OneToMany(targetEntity = ResourceColumn.class, cascade = CascadeType.REMOVE, mappedBy = "projectDetails")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ResourceColumn> resourceColumn = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "formula_text")
    private String formulaText;

    public ProjectDetails() {
    }

    public Integer getProjectDetailsId() {
        return projectDetailsId;
    }

    public void setProjectDetailsId(Integer id) {
        this.projectDetailsId = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<ResourceColumn> getResourceColumn() {
        return resourceColumn;
    }

    public void setResourceColumn(Set<ResourceColumn> resourceColumn) {
        this.resourceColumn = resourceColumn;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "projectDetailsId=" + projectDetailsId +
                ", project=" + project +
                ", resourceColumn=" + resourceColumn +
                ", type=" + type +
                ", formulaText='" + formulaText + '\'' +
                '}';
    }
}

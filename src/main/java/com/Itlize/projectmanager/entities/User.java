package com.Itlize.projectmanager.entities;


import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity", strategy = "com.Itlize.projectmanager.entities.UseExistingIdOtherwiseGenerateUsingIdentity")
    @GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
    private Integer userId;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @CreatedDate
    private Date timeCreate;

    @LastModifiedDate
    private Date lastUpdated;

    @JsonIgnore
    @OneToMany(targetEntity = Project.class, cascade = CascadeType.REMOVE, mappedBy = "owner")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Project> projects = new HashSet<>();

    //empty constructor
    public User() {
    }

    public User(String password, Role role) {
        this.password = password;
        this.role = role;
    }
//		public User(String username, String password, String title, String role, Date timeCreate, Date lastUpdated,
//				Set<Project> projects) {
//			//super();
//			this.username = username;
//			this.password = password;
//			this.title = title;
//			this.role = role;
//			this.timeCreate = timeCreate;
//			this.lastUpdated = lastUpdated;
//			this.projects = projects;
//		}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + "]";
    }



}

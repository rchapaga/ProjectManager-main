package com.itlize.projectmanager.services.serviceImp;


import com.Itlize.projectmanager.ProjectManagerApplication;
import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.Role;
import com.Itlize.projectmanager.entities.User;
import com.Itlize.projectmanager.services.ProjectService;
import com.Itlize.projectmanager.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;


@SpringBootTest(classes = ProjectManagerApplication.class)
public class UserServiceImpTest{

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Test
    void createUser() {
        User user = new User();
        user.setEmail("gggg@gmail.com");
        user.setFirstName("Test");
        user.setLastName("asd");
        user.setPassword("yolo");
        user.setUserName("Mango");
        user.setRole(Role.ADMIN);
//      user.setTimeCreate(new Date());
//      user.setLastUpdated(new Date());
        System.out.println(user.toString());
        Assertions.assertEquals(user.getLastName(),"asd");
        userService.createUser(user);
    }

    @Test
    void createUserAndProjects() {
        User user = new User();
        user.setEmail("yoyo@gmail.com");
        user.setFirstName("yello");
        user.setLastName("man");
        user.setPassword("tt");
        user.setRole(Role.ADMIN);
        Project project = new Project();
        project.setProject_name("troop");
        Project project2 = new Project();
        project2.setProject_name("wowo");
        Set<Project> projectlist = new HashSet<>();
        projectlist.add(project);
        projectlist.add(project2);
        user.setProjects(projectlist);
        userService.createUserAndProjects(user,projectlist);
        Assertions.assertEquals(user.getEmail(),"yoyo@gmail.com");




    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }
}
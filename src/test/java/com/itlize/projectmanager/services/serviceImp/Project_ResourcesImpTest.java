package com.itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.ProjectManagerApplication;
import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.entities.ResourceColumn;
import com.Itlize.projectmanager.repositories.Project_ResourceRepository;
import com.Itlize.projectmanager.services.Project_ResourcesServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ProjectManagerApplication.class)
 public  class Project_ResourcesImpTest {

    @Autowired
    Project_ResourcesServices project_resourcesServices;

//   public List<Project_Resources> getAllProject();
//   public boolean addProject_Resource(Project_Resources project);
//   public boolean createAll(Project_Resources projectResources, Set<Project> project, Set<Resource> resource);
//   public Project_Resources getProject_Resource(Integer id);
//   public List< Project_Resources> findProjectAndResource(Project product, Resource resource);
//   public boolean updateProject(Integer id,Project_Resources project);
//   public boolean deleteProject(Project_Resources project_resources );


    @BeforeEach
    void setUp() {
       Project_Resources project_resources = new Project_Resources();
       project_resources.setFirstName("mellow");
       project_resources.setProjectResourcesId(67);
       project_resourcesServices.addProject_Resource(project_resources);

    }

    @Test
    void addProject_Resource(){
       Project_Resources project_resources1 = new Project_Resources();
       project_resources1.setFirstName("hero man");
       project_resources1.setProjectResourcesId(4);
       String expected = "hero man";
       project_resourcesServices.addProject_Resource(project_resources1);
      Project_Resources projectResources2 = project_resourcesServices.getProject_Resource(4);
       String actual = projectResources2.getFirstName();
      Assertions.assertEquals(expected, actual);

    }

    @Test
    void readProject_Resource(){
       String actualString = "mellow";
       Project_Resources expected = project_resourcesServices.getProject_Resource(67);
       String expectedString = expected.getFirstName();
       Assertions.assertEquals(actualString,expectedString);


    }

    @Test
    void updateProject_Resource(){
       Project_Resources expected = new Project_Resources();
       expected.setFirstName("yohohhoho yo ho ho ho");
       String expectedString = "yohohhoho yo ho ho ho";
       project_resourcesServices.updateProjectResources(67, expected);
       Project_Resources actual = project_resourcesServices.getProject_Resource(67);
       String actualString = actual.getFirstName();
       Assertions.assertEquals(expectedString,actualString);
    }

    @Test
    void deleteProject_Resources(){
       Project_Resources project_resources = new Project_Resources();
       project_resources.setFirstName("la la lol");
       project_resources.setProjectResourcesId(64);
       project_resourcesServices.addProject_Resource(project_resources);
       Assertions.assertTrue(project_resourcesServices.addProject_Resource(project_resources));
       project_resourcesServices.deleteProject(project_resources);
       Assertions.assertNull(project_resourcesServices.getProject_Resource(64));



    }




}
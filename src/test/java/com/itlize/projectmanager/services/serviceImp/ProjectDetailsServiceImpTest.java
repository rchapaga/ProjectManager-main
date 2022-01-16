package com.itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.ProjectManagerApplication;
import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.Type;
import com.Itlize.projectmanager.services.ProjectDetailsServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProjectManagerApplication.class)
class ProjectDetailsServiceImpTest {

    @Autowired
    ProjectDetailsServices projectDetailsServices;

    @BeforeEach
    void setUp() {
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setFormulaText("x + y =4");
        projectDetails.setType(Type.FORMULA);
        projectDetails.setProjectDetailsId(34);
        projectDetailsServices.addProjectDetails(projectDetails);
        ProjectDetails projectDetails2 = new ProjectDetails();
        projectDetails2.setFormulaText("x + z =9");
        projectDetails2.setType(Type.TEXT);
        projectDetails2.setProjectDetailsId(899);
        projectDetailsServices.addProjectDetails(projectDetails2);
        ProjectDetails projectDetails3 = new ProjectDetails();
        projectDetails3.setFormulaText("x + z*2 =9");
        projectDetails3.setType(Type.TEXT);
        projectDetails3.setProjectDetailsId(76);
        projectDetailsServices.addProjectDetails(projectDetails3);


    }

    @Test
    void readProjectDetails() {
        String expected = "x + z =9";
        ProjectDetails projectDetails = projectDetailsServices.readProjectDetails(899);
        String actual = projectDetails.getFormulaText();
        Assertions.assertEquals(actual,expected);


//        ProjectDetails temp = projectDetailsServices.readProjectDetails(899);
//        String actual = temp.getFormulaText();
//
//        Assertions.assertEquals(expected,actual);
    }

    @Test
    void addProjectDetails() {
        ProjectDetails projectDetails3 = new ProjectDetails();
        projectDetails3.setFormulaText("i^2 + y =6");
        projectDetails3.setType(Type.FORMULA);
        projectDetails3.setProjectDetailsId(5);
        String expectedString = "i^2 + y =6";
        projectDetailsServices.addProjectDetails(projectDetails3);
        ProjectDetails actual = projectDetailsServices.readProjectDetails(5);
        String actualString = actual.getFormulaText();
        Assertions.assertEquals(expectedString,actualString);


    }


    @Test
    void updateProjectDetails() {
        ProjectDetails projectDetails4 = projectDetailsServices.readProjectDetails(34);
        String actual = "x^2 + 83z = 90";
        projectDetails4.setFormulaText("x^2 + 83z = 90");
        projectDetailsServices.updateProjectDetails(34,projectDetails4);
        ProjectDetails actualPro = projectDetailsServices.readProjectDetails(34);
        String expected = actualPro.getFormulaText();
        Assertions.assertEquals(actual,expected);



    }

    @Test
    void deleteProjectDetails(){

        ProjectDetails projectDetails = projectDetailsServices.readProjectDetails(76);
        projectDetailsServices.deleteProjectDetails(projectDetails);

        Assertions.assertNull(projectDetailsServices.readProjectDetails(76));

    }

}
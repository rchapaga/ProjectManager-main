package com.itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.ProjectManagerApplication;
import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.ResourceColumn;
import com.Itlize.projectmanager.entities.Type;
import com.Itlize.projectmanager.services.ResourceColumnService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = ProjectManagerApplication.class)
public class ResourceColumnImpTest {

    @Autowired
    ResourceColumnService resourceColumnService;

    @BeforeEach
    void setUp() {
        ResourceColumn resourceColumn = new ResourceColumn();
        resourceColumn.setDetailValue("small small details");
        resourceColumn.setResourceColumnId(5);
        resourceColumnService.createResourceColumn(resourceColumn);
        ResourceColumn resourceColumn1 = new ResourceColumn();
        resourceColumn1.setDetailValue("quite  small details");
        resourceColumn1.setResourceColumnId(7);
        resourceColumnService.createResourceColumn(resourceColumn1);
        ResourceColumn resourceColumn2 = new ResourceColumn();
        resourceColumn2.setDetailValue("extensively  small details");
        resourceColumn2.setResourceColumnId(8);
        resourceColumnService.createResourceColumn(resourceColumn2);
    }


   @Test
    void createResourceColumn() {
       ResourceColumn resourceColumn2 = new ResourceColumn();
       resourceColumn2.setDetailValue("yo yo yo details");
       resourceColumn2.setResourceColumnId(99);
       resourceColumnService.createResourceColumn(resourceColumn2);

       String expectedString = "yo yo yo details";
       ResourceColumn resourceColumn3 = resourceColumnService.readResourceColumn(99);
       String actualString = resourceColumn3.getDetailValue();
       Assertions.assertEquals(expectedString,actualString);



    }



    @Test
    void readResourceColumn() {
        ResourceColumn resourceColumn4 = resourceColumnService.readResourceColumn(8);
        String expected = "extensively  small details";
        String real = resourceColumn4.getDetailValue();
        Assertions.assertEquals(expected,real);



    }

    @Test
    void updateresourceColumn() {
        ResourceColumn resourceColumn4 = new ResourceColumn();
        resourceColumn4.setDetailValue("i love pizza");
        String expected = "i love pizza";

        resourceColumnService.updateresourceColumnbyId(resourceColumn4,5);

        ResourceColumn resourceColumn5 = resourceColumnService.readResourceColumn(5);
        String actual = resourceColumn5.getDetailValue();
        Assertions.assertEquals(expected,actual);



    }

    @Test
    void deleteResourceColumn() {
        ResourceColumn resourceColumn7 = resourceColumnService.readResourceColumn(7);

         resourceColumnService.deleteResourceColumn(resourceColumn7);
        Assertions.assertNull(resourceColumnService.readResourceColumn(7));
    }
}


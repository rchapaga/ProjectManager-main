package com.Itlize.projectmanager.controller;
import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.services.ProjectDetailsServices;
import com.Itlize.projectmanager.services.Project_ResourcesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projectResource")
public class ProjectResourceController {
    
    

    @Autowired
    Project_ResourcesServices project_resourcesServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createProjectDetails(@RequestBody Project_Resources project_resource){
        return project_resourcesServices.addProject_Resource(project_resource);
    }

    @RequestMapping(value = "/createAll", method = RequestMethod.POST)
    public boolean createProjectDetailsAll(@RequestBody Project_Resources project_resource, @RequestBody Set<Project> project, @RequestBody Set<Resource> resources){
        return project_resourcesServices.createAll(project_resource,project,resources);
    }


    @GetMapping("/get/{Id}")
    public Project_Resources  readProject_Resource(@PathVariable Integer Id){
        return project_resourcesServices.getProject_Resource(Id);

    }
    @GetMapping("/get")
    public List<Project_Resources> readAllProject_Resource(){
        return project_resourcesServices.getAllProject();

    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteProjectDetails(@PathVariable Integer Id) {
        Project_Resources project_resource= project_resourcesServices.getProject_Resource(Id);

        return new ResponseEntity<>(project_resourcesServices.deleteProject(project_resource), HttpStatus.OK);

    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<?> updateProject_Resource(@PathVariable Integer Id, @RequestBody Project_Resources project_resource) {


        return new ResponseEntity<>(project_resourcesServices.updateProjectResources(Id, project_resource), HttpStatus.OK);
    }

}

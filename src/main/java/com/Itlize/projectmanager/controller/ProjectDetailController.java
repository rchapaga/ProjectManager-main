package com.Itlize.projectmanager.controller;

import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.repositories.ProjectDetailsRepository;
import com.Itlize.projectmanager.services.ProjectDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.ValidationAnnotationUtils;

@RestController
@RequestMapping("/projectDetails")
public class ProjectDetailController {

    @Autowired
    ProjectDetailsServices projectDetailsServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createProjectDetails(@RequestBody ProjectDetails projectDetails){
        return projectDetailsServices.addProjectDetails(projectDetails);
    }


    @GetMapping("/get/{Id}")
    public ProjectDetails readProjectDetails(@PathVariable Integer Id){
        return projectDetailsServices.readProjectDetails(Id);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteProjectDetails(@PathVariable Integer Id) {
        ProjectDetails projectDetails = projectDetailsServices.readProjectDetails(Id);

        return new ResponseEntity<>(projectDetailsServices.deleteProjectDetails(projectDetails), HttpStatus.OK);

    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<?> updateProjectDetails(@PathVariable Integer Id, @RequestBody ProjectDetails projectDetails) {


        return new ResponseEntity<>(projectDetailsServices.updateProjectDetails(Id, projectDetails), HttpStatus.OK);
    }




}


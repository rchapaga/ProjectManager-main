package com.Itlize.projectmanager.controller;

import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.ResourceColumn;
import com.Itlize.projectmanager.services.ResourceColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resourceColumn")
public class ResourceColumnController {
    @Autowired
    ResourceColumnService resourceColumnService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createResourceColumn(@RequestBody ResourceColumn resourceColumn){
        return resourceColumnService.createResourceColumn(resourceColumn);
    }


    @GetMapping("/get/{Id}")
    public ResourceColumn readResourceColumn(@PathVariable Integer Id){
        return resourceColumnService.readResourceColumn(Id);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteProjectDetails(@PathVariable Integer Id) {
        ResourceColumn  resourceColumn = resourceColumnService.readResourceColumn(Id);

        return new ResponseEntity<>(resourceColumnService.deleteResourceColumn(resourceColumn), HttpStatus.OK);

    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<?> updateProjectDetails(@PathVariable Integer Id, @RequestBody ResourceColumn resourceColumn) {


        return new ResponseEntity<>(resourceColumnService.updateresourceColumnbyId(resourceColumn,Id ), HttpStatus.OK);
    }

}

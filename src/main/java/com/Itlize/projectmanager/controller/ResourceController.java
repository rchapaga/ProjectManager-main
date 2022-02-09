package com.Itlize.projectmanager.controller;

import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.entities.User;
import com.Itlize.projectmanager.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/create")
    public ResponseEntity<?> CreateResource(@RequestBody Resource resource) {
        return new ResponseEntity<>(resourceService.createResource(resource), HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getResource(@PathVariable Integer id) {
        return new ResponseEntity<>(resourceService.findResourceById(id), HttpStatus.OK);
    }


    @GetMapping("/get")
    public List<Resource> readAllResource(){
        return resourceService.findallResources();

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody Resource resource) {
        if(resource == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(resourceService.updateResourcebyId(resource.getResourceId(),resource), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(resourceService.deleteUserbyID(id), HttpStatus.OK);
    }





}

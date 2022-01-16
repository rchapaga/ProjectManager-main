package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.repositories.ResourceRepository;
import com.Itlize.projectmanager.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class ResourceServiceImp implements ResourceService  {


    @Autowired
    private ResourceRepository resourceRepository;



    public Resource createResource(Resource resource) {

        return resourceRepository.save(resource);
    }



    public Resource findResourceById(Integer id) {
        return resourceRepository.findById(id).orElse(null);
    }


    public List<Resource> findallResources() {
        return resourceRepository.findAll();
    }
}

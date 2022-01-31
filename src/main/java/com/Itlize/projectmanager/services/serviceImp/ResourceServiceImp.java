package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.entities.User;
import com.Itlize.projectmanager.repositories.ResourceRepository;
import com.Itlize.projectmanager.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ResourceServiceImp implements ResourceService  {


    @Autowired
    private ResourceRepository resourceRepository;



    public Resource createResource(Resource resource) {

        return resourceRepository.save(resource);
    }



    public Resource findResourceById(Integer id) {

        return resourceRepository.findById(id).orElse(null);
    }

    public boolean updateResourcebyId(Integer id, Resource resource){
        Resource tempResource = new Resource();
        if (resource == null) {
            System.out.println("null input");
            return false;
        }
        try {
            tempResource = resource;
            tempResource.setResourceId(id);
            resourceRepository.save(tempResource);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public List<Resource> findallResources() {

        return resourceRepository.findAll();
    }

    public boolean deleteUserbyID(Integer id ){
        if (id == 0) {
            System.out.println("Not Valid");
            return false;
        }
        try {
            Resource resource = resourceRepository.getById(id);
            resourceRepository.delete(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;


    }


}

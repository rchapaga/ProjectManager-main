package com.Itlize.projectmanager.services;

import com.Itlize.projectmanager.entities.Resource;

import java.util.List;

public interface ResourceService {
    public Resource createResource(Resource resource);

    public Resource findResourceById(Integer id) ;

    public boolean updateResourcebyId(Integer id, Resource resource);

    public boolean deleteUserbyID(Integer id );

    public List<Resource> findallResources();
}

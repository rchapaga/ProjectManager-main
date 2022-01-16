package com.Itlize.projectmanager.services;

import com.Itlize.projectmanager.entities.ResourceColumn;
import com.Itlize.projectmanager.repositories.ResourceColumnRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ResourceColumnService {
    public boolean createResourceColumn(ResourceColumn resourceColumn);
    public ResourceColumn readResourceColumn(Integer resourceColumnid);
    public boolean updateresourceColumnbyId(ResourceColumn resourceColumn, Integer resourceColumnid);
    public boolean deleteResourceColumn(ResourceColumn resourceColumn);
    

}

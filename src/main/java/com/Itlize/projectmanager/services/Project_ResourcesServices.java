package com.Itlize.projectmanager.services;

import com.Itlize.projectmanager.ProjectManagerApplication;
import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.Resource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Project_ResourcesServices {

    public List<Project_Resources> getAllProject();
    public boolean addProject_Resource(Project_Resources project);
    public boolean createAll(Project_Resources projectResources, Set<Project> project, Set<Resource> resource);
    public Project_Resources getProject_Resource(Integer id);
    public List< Project_Resources> findProjectAndResource(Project product, Resource resource);
    public boolean updateProjectResources(Integer id,Project_Resources project);
    public boolean deleteProject(Project_Resources project_resources );
;








    }

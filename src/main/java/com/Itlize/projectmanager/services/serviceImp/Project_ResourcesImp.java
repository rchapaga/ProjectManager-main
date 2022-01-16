package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.entities.User;
import com.Itlize.projectmanager.repositories.ProjectRepository;
import com.Itlize.projectmanager.repositories.Project_ResourceRepository;
import com.Itlize.projectmanager.repositories.ResourceRepository;
import com.Itlize.projectmanager.services.Project_ResourcesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Project_ResourcesImp implements Project_ResourcesServices {


    @Autowired
    private Project_ResourceRepository projectResourceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourceRepository resourceRepository;


    public List<Project_Resources> getAllProject(){
        List<Project_Resources> project = new ArrayList<>();
        projectResourceRepository.findAll().forEach(project::add);
        return project;
    }

    public Project_Resources getProject_Resource(Integer id) {
        return projectResourceRepository.findById(id).orElse(null);
    }

    public boolean addProject_Resource(Project_Resources project) {
        if (project == null) {
            return false;
        }
        try {

            projectResourceRepository.save(project);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean createAll(Project_Resources projectResources, Set<Project> project, Set<Resource> resource){


        if (projectResources == null || project == null || resource == null) {
            System.out.println("null input");
            return false;
        }
        try {
            for(Project proj:project) {
                projectRepository.save(proj);
            }
            for (Resource res : resource) {
                resourceRepository.save(res);
            }
            projectResourceRepository.save(projectResources);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public List< Project_Resources> findProjectAndResource(Project product, Resource resource) {
       return projectResourceRepository.findByProjectAndResource(product,resource);
    }

    public boolean updateProjectResources( Integer id ,Project_Resources project_resources1){
        Project_Resources projectResources = new Project_Resources();
        if(project_resources1 == null){
            return false;
        }try{

                projectResources = project_resources1;
                projectResources.setProjectResourcesId(id);

                projectResourceRepository.save(project_resources1);

            }catch (Exception e){
                e.printStackTrace();
            }
            return true;
        }



    public boolean deleteProject(Project_Resources project_resources){
        if(project_resources == null){
            return false;
        }

        projectResourceRepository.delete(project_resources);
        return true;
    }

}

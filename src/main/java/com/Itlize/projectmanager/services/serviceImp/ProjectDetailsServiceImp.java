package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.repositories.ProjectDetailsRepository;
import com.Itlize.projectmanager.services.ProjectDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDetailsServiceImp implements ProjectDetailsServices {

    @Autowired
    ProjectDetailsRepository projectDetailsRepository;

    public boolean addProjectDetails(ProjectDetails projectDetails){
        if (projectDetails == null){
            System.out.println("No project details found!");
            return false;
        }try{
            projectDetailsRepository.save(projectDetails);
            System.out.println("save success!");

        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public ProjectDetails readProjectDetails(Integer projectDetailsid){
        ProjectDetails returnValue = new ProjectDetails();
        if (projectDetailsid == null){
            System.out.println("unreadable project details!");
            return null;
        }try{
            returnValue = projectDetailsRepository.findById(projectDetailsid).orElse(null);
            System.out.println("found your stuff!");

        }catch(Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean updateProjectDetails(Integer id, ProjectDetails projectDetails1){
           ProjectDetails projectDetails = new ProjectDetails();
        if (projectDetails1 == null){
            System.out.println("No project details found!");
            return false;
        }try{
            projectDetails = projectDetails1;
            projectDetails.setProjectDetailsId(id);
            projectDetailsRepository.save(projectDetails);
            System.out.println("save success!");

        }catch(Exception e){
            e.printStackTrace();
        }
        return true;

    }

    public boolean deleteProjectDetails(ProjectDetails projectDetails){
        if (projectDetails == null){
            System.out.println("No project details found!");
            return false;
        }try{
            projectDetailsRepository.delete(projectDetails);
            System.out.println("delete success!");

        }catch(Exception e){
            e.printStackTrace();
        }
        return true;

    }

}

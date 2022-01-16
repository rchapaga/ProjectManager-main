package com.Itlize.projectmanager.services;

import com.Itlize.projectmanager.entities.ProjectDetails;

public interface ProjectDetailsServices {
    public boolean addProjectDetails(ProjectDetails projectDetails);
    public ProjectDetails readProjectDetails(Integer projectDetailsid);
    public boolean updateProjectDetails( Integer id ,ProjectDetails projectDetails1);
    public boolean deleteProjectDetails(ProjectDetails projectDetails);

}

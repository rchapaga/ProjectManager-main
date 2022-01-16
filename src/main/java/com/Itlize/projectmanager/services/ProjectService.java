package com.Itlize.projectmanager.services;
import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface ProjectService {
    List<Project> findByOwner(User user);

   public Project createProjectbyOwner(User user, Set<Project_Resources> projectResourcesSet, Set<ProjectDetails> projectDetailsSet);



    Project findByProjectId(Integer id);
}

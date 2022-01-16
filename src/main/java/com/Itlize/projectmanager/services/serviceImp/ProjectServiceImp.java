package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.ProjectDetails;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.User;
import com.Itlize.projectmanager.repositories.ProjectRepository;
import com.Itlize.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findByOwner(User user) {
        return projectRepository.findProjectsByOwner(user);

    }

    @Override
    public Project createProjectbyOwner(User user, Set<Project_Resources> projectResourcesSet, Set<ProjectDetails> projectDetailsSet) {
        Project project = new Project();
        project.setOwner(user);
        return projectRepository.save(project);
    }

    @Override
    public Project findByProjectId(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }
}

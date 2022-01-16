package com.Itlize.projectmanager.repositories;

import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.Project_Resources;
import com.Itlize.projectmanager.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Project_ResourceRepository  extends JpaRepository<Project_Resources,Integer> {

    public List<Project_Resources> findByProjectAndResource(Project p, Resource resource);
}

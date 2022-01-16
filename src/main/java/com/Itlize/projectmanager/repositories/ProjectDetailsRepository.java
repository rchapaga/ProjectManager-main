package com.Itlize.projectmanager.repositories;

import com.Itlize.projectmanager.entities.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailsRepository  extends JpaRepository<ProjectDetails,Integer> {




}

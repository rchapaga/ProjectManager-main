package com.Itlize.projectmanager.repositories;

import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
   public List<Project> findProjectsByOwner(User user);





   /* Optional<List<Project>> findByOwner(User user);

   Optional<Project> findByProjectId(Integer projectId);

    Optional<List<Project>> findAllByOwner(User user);

    */
}

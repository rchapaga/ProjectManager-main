package com.Itlize.projectmanager.repositories;

import com.Itlize.projectmanager.entities.ResourceColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceColumnRepository extends JpaRepository<ResourceColumn,Integer> {
    //public ResourceColumn findResourceColumnByResourceColumnId(Integer resourceColumnId);

}

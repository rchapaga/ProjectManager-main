package com.Itlize.projectmanager.repositories;

import com.Itlize.projectmanager.entities.Resource;
import com.Itlize.projectmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer>{


}

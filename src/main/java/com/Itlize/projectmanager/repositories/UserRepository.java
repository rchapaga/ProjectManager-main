package com.Itlize.projectmanager.repositories;

import com.Itlize.projectmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{


    //check UserServiceimp for details
//    Optional<List<User>> getallUser();


}

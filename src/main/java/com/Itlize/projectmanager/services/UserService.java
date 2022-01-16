package com.Itlize.projectmanager.services;

import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;



public interface UserService {
    public List<User> getAllUser();
    public User createUser(User user);
    public User createUserAndProjects(User user, Set <Project> project);
    public Optional<User> getUserById(Integer user_name);
    public void updateUser(User user);
    public void deleteUser(User user, Set<Project> projects);
}

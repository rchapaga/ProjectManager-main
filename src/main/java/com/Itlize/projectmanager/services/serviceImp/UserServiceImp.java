package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.Project;
import com.Itlize.projectmanager.entities.User;

import com.Itlize.projectmanager.repositories.ProjectRepository;
import com.Itlize.projectmanager.repositories.UserRepository;

import com.Itlize.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;



        public List<User> getAllUser(){
            List<User> user = new ArrayList<>();
            userRepository.findAll().forEach(user::add);
            return user;
        }

    public User createUser(User user){
        User user1 = new User();
            if (user == null){
                System.out.println("invalid input! User is null");
                return null;
            }try{
                user1 = userRepository.save(user);
        }catch (Exception e){
                e.printStackTrace();
        }
            return user1;
    }



    public User createUserAndProjects(User user, Set<Project> project) {
            User result = new User();

            if (user == null || project == null) {
                System.out.println("null input");
                return null;
            }
            try {
                for(Project proj:project) {
                    projectRepository.save(proj);
                }
                 result = userRepository.save(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }





        public Optional<User> getUserById(Integer user_name){


            return userRepository.findById(user_name);
        }

        public boolean updateUserbyId( Integer id, User user){
            User tempUser = new User();
            if (user == null) {
                System.out.println("null input");
                return false;
            }
            try {
                tempUser = user;
                tempUser.setUserId(id);
                userRepository.save(tempUser);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        public void deleteUserProject(User user, Set<Project> project){
            if (user == null || project == null){
                System.out.println("null input");
            }
            try{
                Set<Project> pr = new HashSet<Project>();


                for(Project pro : project){

                    projectRepository.delete(pro);
                }
                userRepository.delete(user);
            }catch(Exception e){
                e.printStackTrace();
            }



        }

    public boolean deleteUser( User user) {
        if (user == null) {
            System.out.println("null input");
        }
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }


        public boolean deleteUserbyID(Integer id ){
            if (id == 0) {
                System.out.println("Not Valid");
            }
            try {
                User user = userRepository.getById(id);
                userRepository.delete(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;


        }

    }







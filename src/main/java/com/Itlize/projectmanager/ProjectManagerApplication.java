package com.Itlize.projectmanager;

import com.Itlize.projectmanager.entities.ResourceColumn;
import com.Itlize.projectmanager.repositories.ResourceColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectManagerApplication {





    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);


    }


}

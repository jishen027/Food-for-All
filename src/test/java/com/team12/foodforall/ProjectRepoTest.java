package com.team12.foodforall;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.ProjectRepository;
import com.team12.foodforall.repository.UserRepository;
import com.team12.foodforall.service.project.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author: Heng Gao
 * @date: 29/03/2022 17:02
 **/
@SpringBootTest
public class ProjectRepoTest {

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectService projectService;

    @Test
    void TestFindAll(){
        assertThat(projectRepo).isNotNull();

        List<Project> projectLists = new ArrayList<>();


        // search
        projectLists = projectRepo.findAll();
        assertThat(projectLists).isNotNull();
        System.out.println(projectLists.size());




        // store 2 random projects

        Project p1 = createRandomProject();
        Project p2 = createRandomProject();

        String emailToCreate = "a@a.com";
        User owner = new User();
        User result = userRepository.findByEmail(emailToCreate);
        if(null == result){ // not found, so create
            owner.setFirstName("jack");
            owner.setLastName("westwood");
            owner.setEmail("a@a.com");// this needs to be unique
            owner.setPassword("asdasdasd");
            owner.setCharityName("UK abc Charity");
        } else{ // found , then use it
            owner = result;
        }

        userRepository.save(owner);
        p1.setUser(owner);
        p2.setUser(owner);
        projectService.addProject(p1);
        projectService.addProject(p2);

        // search again
        projectLists =projectRepo.findAll();
        assertThat(projectLists.size()).isNotEqualTo(0);
        System.out.println(projectLists.size());

    }

    // Create a project with random projectId and userId
    private Project createRandomProject() {
        Project p = new Project();
        Random r = new Random();
        p.setId(r.nextLong());
        p.setTitle("title" + r.nextInt());
        p.setContent("this is a good project");
        p.setTargetmeals(22);
        p.setPrice(2.99F);
        p.setPositionName("UK");
        return p;
    }

}

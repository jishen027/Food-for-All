package com.team12.foodforall.service.project;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author: Heng Gao
 * @date: 29/03/2022 21:26
 **/
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project addProject(@Valid Project project) {

        if(projectRepository.existsByTitle(project.getTitle())) {
            throw new RuntimeException("project exist");
        }

        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project updateProjectProgress(Long id, Integer amt){
        Project update = projectRepository.findById(id).get();
        Integer current = update.getAchievedmeals();
        Integer goal = update.getTargetmeals();

        Float prog = (current.floatValue()+amt)/goal.floatValue();
        update.setAchievedmeals(current+amt);
        update.setProgress(prog);
        return projectRepository.save(update);
    }

    @Override
    public Project updateProjectProgressSub(Long id){
        Project update = projectRepository.findById(id).get();
        Integer current = update.getAchievedmeals();
        Integer goal = update.getTargetmeals();
        Float prog = (current.floatValue()+1)/goal.floatValue();
        update.setAchievedmeals(current+1);
        update.setProgress(prog);
        return projectRepository.getById(id);//projectRepository.save(update);
    }
}

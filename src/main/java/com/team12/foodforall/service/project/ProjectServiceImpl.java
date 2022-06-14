package com.team12.foodforall.service.project;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Project addProject(Project project) {

        // validate title duplication
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
    public int countProjects() {
        return projectRepository.findAll().size();
    }

    @Override
    public double countTotalRevenue() {
        return projectRepository.findAll().stream().mapToDouble(p->p.getCurrentRevenue().doubleValue()).sum();
    }

    @Override
    public int countCompletedProjectNumber() {
        return (int) projectRepository.findAll().stream().filter(Project::isCompleted).count();
    }

    @Override
    public List<Project> getToalRevenueForAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProjectProgress(Long id, Integer amt){
        Project update = projectRepository.findById(id).get();
        Integer current = update.getAchievedmeals();
        Integer goal = update.getTargetmeals();

        Float prog = (current.floatValue()+amt)/goal.floatValue();
        update.setAchievedmeals(current+amt);
        update.setCurrentRevenue((double) (update.getAchievedmeals()*update.getPrice()));
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
        update.setCurrentRevenue((double) (update.getAchievedmeals()*update.getPrice()));
        update.setProgress(prog);
        return projectRepository.getById(id);//projectRepository.save(update);
    }
}

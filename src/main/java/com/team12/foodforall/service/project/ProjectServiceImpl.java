package com.team12.foodforall.service.project;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public int countTotalRevenue() {
        return projectRepository.findAll().stream().mapToInt(p-> (int) (p.getAchievedmeals() * p.getPrice())).sum();
    }

    @Override
    public int countCompletedProjectNumber() {
        return (int) projectRepository.findAll().stream().filter(Project::isCompleted).count();
    }

    @Override
    public Map<Long, Float> getAllProjectRevenue() {
        return projectRepository.findAll().stream().collect(Collectors.toMap(Project::getId,Project::getTotalRevenue));
    }

    @Override
    public Map<Long, Float> getAverageRevenueList() {
        //TODO: do we need avg List?
        return new HashMap<Long,Float>();
    }


}

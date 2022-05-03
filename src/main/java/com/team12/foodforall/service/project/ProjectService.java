package com.team12.foodforall.service.project;

import com.team12.foodforall.domain.Project;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * @author: Heng Gao
 * @date: 29/03/2022 21:24
 **/
@Service
public interface ProjectService {


    Project addProject(Project project);

    Optional<Project> findById(Long id);

    int countProjects();

    int countTotalRevenue();

    int countCompletedProjectNumber();

    Map<Project, Float> getToalRevenueForAllProjects();
}

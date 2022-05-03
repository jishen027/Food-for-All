package com.team12.foodforall.controller.dashboard;

import com.team12.foodforall.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Heng Gao
 * @date: 02/05/2022 22:44
 **/

@RestController
public class DashboardController {

    private final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    ProjectService projectService;

    @RequestMapping("api/dashboard/getData")
    @ResponseBody
    DashboardData getData(){
        DashboardData data = new DashboardData();

        data.setNumOfProjects(projectService.countProjects());
        data.setTotalRevenue(projectService.countTotalRevenue());
        data.setNumOfCompletedProjects(projectService.countCompletedProjectNumber());
        data.setRevenueList(projectService.getAllProjectRevenue());
        data.setAverageRevueList(projectService.getAverageRevenueList());

        logger.info("Counting projects:" + projectService.countProjects());

        return data;
    }
}

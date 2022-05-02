package com.team12.foodforall.controller.project;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.service.project.ProjectService;
import com.team12.foodforall.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author: Heng Gao
 * @date: 02/05/2022 19:57
 **/
@Controller
public class DashboardController {


    private final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping("/dashboard")
    public String index(HttpSession session, Model model){

        Project p1 = new Project();
        p1.setId(101L);
        p1.setTitle("P1 title1");
        Project p2 = new Project();
        p2.setId(102L);
        p2.setTitle("P2 title2");
        ArrayList<Project> projectList = new ArrayList<Project>();
        projectList.add(p1);
        projectList.add(p2);




        // the string tell which page to go, by deafult its under /resource and /resource/template and /resource/public and /rouserce/static
        return "index";
    }

    @RequestMapping("/dashboard-graphs")
    public String dashboardGraphs(){
        return "dashboard-graphs";
    }


    @RequestMapping("/dashboard-projects")
    public String dashboardProjects(){
        return "dashboard-projects";
    }

}

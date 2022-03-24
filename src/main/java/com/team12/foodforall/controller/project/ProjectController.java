package com.team12.foodforall.controller.project;

import com.team12.foodforall.domain.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :15:13
 **/
@Controller
public class ProjectController {

    @RequestMapping("/")
    public String index(HttpSession session, Model model){

        session.setAttribute("loginStatus","true");
        session.setAttribute("userName","gh");
        session.setAttribute("userId",101);
        session.setAttribute("userRole","admin");


        Project p1 = new Project();
        p1.setId(101L);
        p1.setTitle("P1 title1");

        Project p2 = new Project();
        p2.setId(102L);
        p2.setTitle("P2 title2");


        ArrayList<Project> projectList = new ArrayList<Project>();
        projectList.add(p1);
        projectList.add(p2);

        model.addAttribute("projects",projectList);
        // the string tell which page to go, by deafult its under /resource and /resource/template and /resource/public and /rouserce/static
        return "index";
    }

    // router for return the projects views
    @RequestMapping("/projects")
    public String projects(){
        return "projects";
    }

    @RequestMapping("/dashboard-graphs")
    public String dashboardGraphs(){
        return "dashboard-graphs";
    }



}

package com.team12.foodforall.controller.project;

import com.team12.foodforall.domain.Project;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.ProjectRepository;
import com.team12.foodforall.service.project.ProjectService;
import com.team12.foodforall.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :15:13
 **/
@Controller
public class ProjectController {


    private static String data_src;

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepo;

    @RequestMapping("/")
    public String index(HttpSession session, Model model){

        ArrayList<Project> projectList = (ArrayList<Project>) projectRepo.findAll();


        model.addAttribute("projects", projectList);

        // the string tell which page to go, by deafult its under /resource and /resource/template and /resource/public and /rouserce/static
        return "index";
    }

    // router for return the projects views
    @GetMapping("/projects")
    public String projects(Model model){
        // retrie ve all data from
        ArrayList<Project> projects = (ArrayList<Project>) projectRepo.findAll();

        model.addAttribute("projects", projects);
        return "projects";
    }



    @GetMapping("/projects/add")
    public String getAddProjectPage(Project project, Model model){
        return "addProject";
    }


    // router for return the projects views
    @PostMapping("/projects")
    public String saveProject(Model model, @Valid Project project,
                              BindingResult error, @RequestParam("img") MultipartFile file) throws IOException {

//      TODO :  Service.();

//        StringUtils.cleanPath()

        String img = Base64.getEncoder().encodeToString(file.getBytes());
        project.setImg(img); // img in String

        // V2 retrieve all data from
        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        project.setUser(user);
        Project savedProject = projectService.addProject(project);

        return "redirect:/projects";
    }

    @RequestMapping("/detail")
    public String projectDetail(){
        return "project_detail";
    }

}



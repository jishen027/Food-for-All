package com.team12.foodforall.service.project;

import com.team12.foodforall.domain.Project;
import org.springframework.stereotype.Service;

/**
 * @author: Heng Gao
 * @date: 29/03/2022 21:24
 **/
@Service
public interface ProjectService {

    Project addProject(Project project);
}

package com.coding_site.controller;

import com.coding_site.dto.ProjectDto;
import com.coding_site.model.Project;
import com.coding_site.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/createProject")
    public ResponseEntity<Project> createUserProject(@RequestBody ProjectDto projectDto) {

        try {

            return new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}

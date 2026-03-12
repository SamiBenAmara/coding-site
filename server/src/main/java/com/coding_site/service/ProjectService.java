package com.coding_site.service;

import com.coding_site.dto.ProjectDto;
import com.coding_site.model.Project;
import com.coding_site.model.User;
import com.coding_site.repository.ProjectRepository;
import com.coding_site.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public Project createProject(ProjectDto projectDto) {

        try {

            Optional<User> foundUser = userRepository.findById(projectDto.getUserId());

            if (foundUser.isPresent()) {

                Project project = projectDto.getProject();
                project.setOwner(foundUser.get());

                projectRepository.save(project);

                foundUser.get().addUserProject(projectDto.getProject());
                userRepository.save(foundUser.get());

                return project;

            }

            throw new IllegalStateException("User not found");

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

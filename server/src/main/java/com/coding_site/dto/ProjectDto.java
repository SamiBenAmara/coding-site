package com.coding_site.dto;

import com.coding_site.model.Project;

public class ProjectDto {

    private Long userId;

    private Project project;

    public ProjectDto () {

    }

    public ProjectDto(Long userId, Project project) {
        this.userId = userId;
        this.project = project;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

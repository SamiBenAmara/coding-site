package com.coding_site.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_type")
    private String projectType;

    @ElementCollection
    @Column(name = "project_languages")
    private List<String> projectLanguages;

    @ElementCollection
    @Column(name = "project_technologies")
    private List<String> projectTechnologies;

    @Column(name = "project_views")
    private int views;

    @ManyToMany(mappedBy = "projects")
    private Set<User> users = new HashSet<>();

    public Project() {

    }

    public Project(Long id, String projectType, List<String> projectLanguages, List<String> projectTechnologies, int views) {
        this.id = id;
        this.projectType = projectType;
        this.projectLanguages = projectLanguages;
        this.projectTechnologies = projectTechnologies;
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public List<String> getProjectLanguages() {
        return projectLanguages;
    }

    public void setProjectLanguages(List<String> projectLanguages) {
        this.projectLanguages = projectLanguages;
    }

    public List<String> getProjectTechnologies() {
        return projectTechnologies;
    }

    public void setProjectTechnologies(List<String> projectTechnologies) {
        this.projectTechnologies = projectTechnologies;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectType='" + projectType + '\'' +
                ", projectLanguages=" + projectLanguages +
                ", projectTechnologies=" + projectTechnologies +
                ", views=" + views +
                ", users=" + users +
                '}';
    }
}

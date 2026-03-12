package com.coding_site.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

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
    private Set<User> users;

    public Project() {

    }

    public Project(Long projectId, String projectName, String projectType, List<String> projectLanguages, List<String> projectTechnologies, int views) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectLanguages = projectLanguages;
        this.projectTechnologies = projectTechnologies;
        this.views = views;
    }

    public Project(String projectName, String projectType, List<String> projectLanguages, List<String> projectTechnologies, int views) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectLanguages = projectLanguages;
        this.projectTechnologies = projectTechnologies;
        this.views = views;
    }

    public Project(String projectName, User owner, String projectType, List<String> projectLanguages, List<String> projectTechnologies, int views) {
        this.projectName = projectName;
        this.owner = owner;
        this.projectType = projectType;
        this.projectLanguages = projectLanguages;
        this.projectTechnologies = projectTechnologies;
        this.views = views;
    }

    public Long getId() {
        return projectId;
    }

    public void setId(Long projectIdd) {
        this.projectId = projectId;
    }

    public String getProjectName() { return projectName; }

    public void setProjectName(String projectName) { this.projectName = projectName; }

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + projectId +
                "owner=" + owner +
                ", projectType='" + projectType + '\'' +
                ", projectLanguages=" + projectLanguages +
                ", projectTechnologies=" + projectTechnologies +
                ", views=" + views +
//                ", users=" + users +
                '}';
    }
}

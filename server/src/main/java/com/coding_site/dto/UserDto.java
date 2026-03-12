package com.coding_site.dto;

import com.coding_site.model.Project;

public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String userName;
    private String email;

    private Project project;

    public UserDto() {

    }

    // For creating a new project
    public UserDto(Long userId, Project project) {
        this.userId = userId;
        this.project = project;
    }

    public UserDto(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public UserDto(Long userId, String firstName, String lastName, String userName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                ", userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.coding_site.dto;

public class UserDto {

    private Long userId;
    private String email;

    public UserDto() {

    }

    public UserDto(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

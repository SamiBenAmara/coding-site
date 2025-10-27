package com.coding_site.dto;

public class PostDto {

    private Long userId;

    private String postTitle;

    private String postCaption;

    public PostDto() {

    }

    public PostDto(Long userId, String postTitle, String postCaption) {
        this.userId = userId;
        this.postTitle = postTitle;
        this.postCaption = postCaption;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostCaption() {
        return postTitle;
    }

    public void setPostCaption(String postCaption) {
        this.postCaption = postCaption;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                ", postTitle='" + postTitle + '\'' +
                ", postCaption='" + postCaption + '\'' +
                '}';
    }
}

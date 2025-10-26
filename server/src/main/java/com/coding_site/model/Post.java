package com.coding_site.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "like_count")
    private Long likeCount;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "users_who_liked_post", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "users_who_liked")
    private Set<String> usersWhoLiked = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "post_comments", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "comment")
    private List<String> comments = new ArrayList<>();

    public Post() {

    }

    public Post(Long postId, User user, Long likeCount) {
        this.postId = postId;
        this.user = user;
        this.likeCount = likeCount;
    }

    public Long getPostId() {
        return postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLike(Long likeCount) {
        this.likeCount = likeCount;
    }
}

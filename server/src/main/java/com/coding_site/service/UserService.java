package com.coding_site.service;

import com.coding_site.dto.PostDto;
import com.coding_site.dto.UserDto;
import com.coding_site.mapper.UserMapper;
import com.coding_site.model.Post;
import com.coding_site.model.User;
import com.coding_site.repository.PostRepository;
import com.coding_site.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public List<UserDto> getAllUsers() {

        List<User> userList = userRepository.findAll();

        return userList.stream().map(user -> new UserDto(user.getId(), user.getEmail())).collect(Collectors.toList());
    }

    public UserDto createUser(User user) {

        try {
            userRepository.save(user);
            return new UserDto(user.getId(), user.getEmail());
        } catch (Exception e) {
            throw new IllegalStateException("USER CANNOT BE CREATED");
        }
    }

    public UserDto loginUser(User user) {

        try {
            User foundUser = userRepository.findByEmail(user.getEmail());

            if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
                throw new IllegalStateException("USER DOES NOT EXIST");
            } else {
                return new UserDto(foundUser.getId(), foundUser.getEmail());
            }
        } catch (Exception e) {
            throw new IllegalStateException("USER DOES NOT EXIST");
        }
        
    }

    public Post createPost(PostDto postData) {

        try {

            Optional<User> user = userRepository.findById(postData.getUserId());

            if (user.isPresent()) {
                Post post = new Post();
                post.setPostTitle(postData.getPostTitle());
                post.setPostCaption(postData.getPostCaption());
                post.setUser(user.get());
                post.setLikeCount((long)0);

                postRepository.save(post);
                userRepository.save(user.get());

                return post;
            } else {
                throw new IllegalStateException("User does not exist");
            }

        } catch (Exception e) {
            throw new IllegalStateException("CANNOT CREATE POST");
        }
    }

    public void followUser(Long userId, Long followingId) {

        try {

            Optional<User> user = userRepository.findById(userId);

            if (user.isPresent()) {

                Optional<User> user_following = userRepository.findById(followingId);
                if (user_following.isPresent()) {
                    user.get().followUser(user_following.get());
                }

                userRepository.save(user.get());
            } else {
                throw new IllegalStateException("USER NOT FOUND");
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void unfollowUser(Long userId, Long followingId) {

        try {

            Optional<User> user = userRepository.findById(userId);

            if (user.isPresent()) {

                Optional<User> followingUser = userRepository.findById(followingId);
                user.get().unfollowUser(followingUser.get());

            }

            userRepository.save(user.get());

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public UserDto getUserInfo(Long userId) {

        try {

            Optional<User> user = userRepository.findById(userId);

            if (user.isPresent()) {
                return UserMapper.fullToDto(user.get());
            } else {
                throw new IllegalStateException("USER NOT FOUND");
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

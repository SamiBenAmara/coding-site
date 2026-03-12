package com.coding_site.controller;

import com.coding_site.dto.PostDto;
import com.coding_site.dto.UserDto;
import com.coding_site.model.User;
import com.coding_site.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> userSignup(@RequestBody User user) {

        try {
            UserDto foundUser = userService.createUser(user);
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> userLogin(@RequestBody User user) {
        
        try {
            UserDto foundUser = userService.loginUser(user);
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto) {

        try {
            userService.createPost(postDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("POST COULD NOT BE CREATED", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/followUser")
    public ResponseEntity<String> followUser(@RequestBody Map<String, Long> requestBody) {

        try {

            Long userId = requestBody.get("userId");
            Long followingId = requestBody.get("followingId");

            userService.followUser(userId, followingId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/unfollowUser")
    public ResponseEntity<String> unfollowUser(@RequestBody Map<String, Long> requestBody) {

        try {

            Long userId = requestBody.get("userId");
            Long followingId = requestBody.get("followingId");

            userService.unfollowUser(userId, followingId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<UserDto> getUserInfo(@RequestParam Long userId) {

        try {

            UserDto userDto = userService.getUserInfo(userId);
            return new ResponseEntity<>(userDto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

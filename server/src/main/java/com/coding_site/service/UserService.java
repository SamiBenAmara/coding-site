package com.coding_site.service;

import com.coding_site.dto.UserDto;
import com.coding_site.model.User;
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

    public List<UserDto> getAllUsers() {

        List<User> userList = userRepository.findAll();

        List<UserDto> userDtoList = userList.stream().map(user -> new UserDto(user.getFirstName(), user.getLastName(), user.getEmail()) ).collect(Collectors.toList());

        return userDtoList;
    }

    public User createUser(User user) {

        try {
            return userRepository.save(user);
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
                return new UserDto(foundUser.getFirstName(), foundUser.getLastName(), foundUser.getEmail());
            }
        } catch (Exception e) {
            throw new IllegalStateException("USER DOES NOT EXIST");
        }
        
    }

}

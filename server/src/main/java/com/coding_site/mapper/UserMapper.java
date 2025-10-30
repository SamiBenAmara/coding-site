package com.coding_site.mapper;

import com.coding_site.dto.UserDto;
import com.coding_site.model.User;

public class UserMapper {

    public static UserDto basicToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail()
        );
    }

    public static UserDto fullToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail()
        );
    }
}

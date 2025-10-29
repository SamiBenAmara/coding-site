package com.coding_site.mapper;

import com.coding_site.dto.UserDto;
import com.coding_site.model.User;

public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail()
        );
    }
}

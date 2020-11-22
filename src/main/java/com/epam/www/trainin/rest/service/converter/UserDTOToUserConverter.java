package com.epam.www.trainin.rest.service.converter;

import com.epam.www.trainin.rest.service.dto.UserDTO;
import com.epam.www.trainin.rest.service.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Convert a given {@link UserDTO} to {@link User}.
 */
@Service
public class UserDTOToUserConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUserName());
    }
}

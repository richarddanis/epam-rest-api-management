package com.epam.www.trainin.rest.service.converter;

import com.epam.www.trainin.rest.service.dto.UserDTO;
import com.epam.www.trainin.rest.service.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Convert a given {@link User} to Optional {@link UserDTO} object.
 */
@Service
public class UserToUserDTOConverter implements Converter<User, Optional<UserDTO>> {

    @Override
    public Optional<UserDTO> convert(User user) {
        return Optional.of(new UserDTO(user.getId(), user.getUserName()));
    }
}

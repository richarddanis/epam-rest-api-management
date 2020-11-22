package com.epam.www.trainin.rest.service.service;

import com.epam.www.trainin.rest.service.converter.UserDTOToUserConverter;
import com.epam.www.trainin.rest.service.converter.UserToUserDTOConverter;
import com.epam.www.trainin.rest.service.exception.EntityNotFoundException;
import com.epam.www.trainin.rest.service.model.User;
import com.epam.www.trainin.rest.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserToUserDTOConverter userDTOConverter;
    private final UserDTOToUserConverter userConverter;

    public UserService(UserRepository userRepository,
                       UserToUserDTOConverter userDTOConverter,
                       UserDTOToUserConverter userConverter) {
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
        this.userConverter = userConverter;
    }

    public User saveUser(User user) {
        return Objects.requireNonNull(userDTOConverter.convert(user))
                .map(userRepository::save)
                .map(userConverter::convert)
                .orElseThrow(() -> new EntityNotFoundException("Cannot save the entity: " + user));
    }

    public List<User> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toList());
    }

    public User getUserById(long id) throws EntityNotFoundException {
        return userRepository.findById(id)
                .map(userConverter::convert)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    public User updateUser(User user) {
        return Objects.requireNonNull(userDTOConverter.convert(user))
                .map(userRepository::save)
                .map(userConverter::convert)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    public void deleteUserById(long id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }
 }

package com.epam.www.trainin.rest.service.repository;

import com.epam.www.trainin.rest.service.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {
}

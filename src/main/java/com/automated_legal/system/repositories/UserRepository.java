package com.automated_legal.system.repositories;

import com.automated_legal.system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail (String email);

}

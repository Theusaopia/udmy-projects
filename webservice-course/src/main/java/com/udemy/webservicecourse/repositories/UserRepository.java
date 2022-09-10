package com.udemy.webservicecourse.repositories;

import com.udemy.webservicecourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

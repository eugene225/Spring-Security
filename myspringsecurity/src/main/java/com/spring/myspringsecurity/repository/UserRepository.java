package com.spring.myspringsecurity.repository;

import com.spring.myspringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

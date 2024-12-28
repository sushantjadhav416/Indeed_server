package com.indeed.server.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indeed.server.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	Optional<User> findByUsernameOrEmail(String username, String email);
}

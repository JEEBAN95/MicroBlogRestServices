package com.mv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mv.api.entity.User;

/**
 * Repository for performing persistence operation of {@link User} to database
 * 
 * @author Jeeban
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
}

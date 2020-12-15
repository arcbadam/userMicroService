package com.ibm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.user.entity.User;


public interface UserRepository extends  JpaRepository<User, Integer> {
	User findByUsername(String username);
}
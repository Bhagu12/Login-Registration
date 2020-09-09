package com.example.MyApplicaition.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.MyApplicaition.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsernameAndPasword(String username, String pasword);
}

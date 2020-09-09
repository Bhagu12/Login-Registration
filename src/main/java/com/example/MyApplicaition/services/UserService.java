package com.example.MyApplicaition.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.MyApplicaition.model.User;
import com.example.MyApplicaition.repository.UserRepository;


@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void saveUser(User user)
	{
		userRepository.save(user);
	}
	
	public List<User> listAllUser()
	{
		List<User> list = new ArrayList<User>();
		for(User user : userRepository.findAll()) {
			list.add(user);
		}
		return list;
	}
	
	public void deleteMyUser(int id)
	{
		userRepository.deleteById(id);
	}
	
	public User editUser(int id) {
		Optional<User> userResponse = userRepository.findById(id);
		User user = userResponse.get();
		return user;
	}
	
	public User findByUsernameAndPassword(String username, String pasword) {
		return userRepository.findByUsernameAndPasword(username, pasword);
	}
}

package com.dave.review.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dave.review.models.Ring;
import com.dave.review.models.Role;
import com.dave.review.models.User;
import com.dave.review.repositories.RingRepository;
import com.dave.review.repositories.RoleRepository;
import com.dave.review.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private RingRepository ringRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RingRepository ringRepository){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository; 
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.ringRepository = ringRepository;
	}
	//Saves a client with only the user role
	public void saveWithUserRole(User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	//Save a client with only the admin role
	public void saveUserWithAdminRole(User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}
	//Find user by username
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	public void AddRingToUser(Ring ring, User user) {
		System.out.println("reached AddRingToUser in UserService");
		System.out.println(ring.getName());
		ring.setPickedUp(true);
		ring.setUser(user);
		ringRepository.save(ring);
	}
}
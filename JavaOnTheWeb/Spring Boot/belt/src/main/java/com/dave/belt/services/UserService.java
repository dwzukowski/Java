package com.dave.belt.services;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dave.belt.models.Pack;
import com.dave.belt.models.User;
import com.dave.belt.repositories.RoleRepository;
import com.dave.belt.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository; 
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
	public List<User> allUsers() {
		return (List<User>) userRepository.findAll();
	}
	public void addPackToUser(Pack pack, User user) {
		user.setPack(pack);
		userRepository.save(user);
	}
	public List<User> findCustomers() {
		return userRepository.findCustomers();
	}
	public User findById(long id) {
		return userRepository.findById(id);
	}
	public void updateUser(User user) {
		userRepository.save(user);
	}
}

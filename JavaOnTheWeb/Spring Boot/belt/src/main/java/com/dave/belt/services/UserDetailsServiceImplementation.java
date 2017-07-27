package com.dave.belt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dave.belt.models.Role;
import com.dave.belt.models.User;
import com.dave.belt.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	private UserRepository userRepository;
	
	public UserDetailsServiceImplementation(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	//Find user by username; if found, return the correct authorities. If not found, method throws an error
	@Override
	public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException{
		User byUsername = userRepository.findByUsername(input);
		User byEmail = userRepository.findByEmail(input);
		if(byUsername == null && byEmail == null){
			throw new UsernameNotFoundException("User not found");
		}
		if (byUsername != null){
			return new org.springframework.security.core.userdetails.User(byUsername.getUsername(),
                    byUsername.getPassword(), getAuthorities(byUsername));
		}
		return new org.springframework.security.core.userdetails.User(byEmail.getUsername(), byEmail.getPassword(),
                getAuthorities(byEmail));
	}
	//return list of authorities/permission for a specific user; for Spring Security to implement authorization, must get name of the possible roles for current user from the database and create new SimpleGrantedAuthority object with those roles 
	private List<GrantedAuthority> getAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()){
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities; 
	}
}

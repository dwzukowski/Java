package com.dave.belt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dave.belt.models.Pack;
import com.dave.belt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	User findByEmail(String input);

	@Query(value="SELECT * FROM users WHERE pack_id IS NOT NULL", nativeQuery=true)
	List<User> findCustomers();

	User findById(long id);
}


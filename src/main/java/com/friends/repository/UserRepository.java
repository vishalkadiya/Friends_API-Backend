package com.friends.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.friends.entity.User;

public interface UserRepository extends CrudRepository<User,Integer>{


	Optional<User> findByEmail(String email);

	Optional<User> findByImage(byte[] image);

	@Query("select u from User u where u.firstname = :firstname")
	List<User> myNativeQuery(@Param("firstname") String firstname);
	
}

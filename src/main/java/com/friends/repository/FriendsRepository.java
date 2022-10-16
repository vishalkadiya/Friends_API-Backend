package com.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.friends.entity.Friends;
import com.friends.entity.User;

@Repository
public interface FriendsRepository extends CrudRepository<Friends,Integer>{

	@Query("SELECT f FROM Friends f WHERE f.user1 = :user1")
	List<Friends> findByuser1(@Param("user1") User user);
	
}

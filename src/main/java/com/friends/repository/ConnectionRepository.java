package com.friends.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.friends.entity.Connection;
import com.friends.entity.User;

public interface ConnectionRepository extends CrudRepository<Connection,Integer>
{

	Optional<Connection> findBysenderid(User user);

	Optional<Connection> findByreceiverid(User user);
	
	@Query("SELECT u FROM Connection u WHERE u.senderid = ?1 AND u.receiverid = ?2 ")
	Optional<Connection> findByreceiveridAndsenderid(User senderid,User receiverid);

    @Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Connection u where u.senderid = ?1 AND u.receiverid = ?2")
	void findBysenderidANDreceiverid(User user, User user2);

 
}

package com.friends.services;

import org.springframework.http.ResponseEntity;
public interface FriendsService {

	ResponseEntity<?> findByReceiverId(Integer senderid, Integer recevierid);
	ResponseEntity<?> findByuser1(Integer userid);



}

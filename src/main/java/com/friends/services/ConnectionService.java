package com.friends.services;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.friends.entity.User;

public interface ConnectionService {

	public ResponseEntity save(User senderId, User reciverId);

//	public ResponseEntity findBySenderId(Integer id);
//
//	public ResponseEntity findByReceiverId(Integer id);

	public ResponseEntity deleteBySenderIdANDReceiverId(Integer id, Integer id1);

	
}

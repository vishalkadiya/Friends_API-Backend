package com.friends.servicesImpl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.friends.entity.Connection;
import com.friends.entity.User;
import com.friends.repository.ConnectionRepository;
import com.friends.repository.UserRepository;
import com.friends.request.ConnectionRequest;
import com.friends.services.ConnectionService;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	
	@Autowired
	ConnectionRepository connectionRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity save(User senderId,User reciverId) {
		
		Connection  connection = new Connection();
		connection.setReceiverid(reciverId);
		connection.setSenderid(senderId);
		return ResponseEntity.ok(connectionRepository.save(connection));		
	}

//	@Override
//	public ResponseEntity findBySenderId(Integer id) {
//		Optional<Connection> connection = connectionRepository.findBysenderid(userRepository.findById(id).get());
//		if(!connection.isEmpty())
//		{
//			return ResponseEntity.ok("Request already sent");
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request not found");
//		}	
//	}
//
//	@Override
//	public ResponseEntity findByReceiverId(Integer id) {
//		Optional<Connection> connection = connectionRepository.findByreceiverid(userRepository.findById(id).get());
//		if(!connection.isEmpty())
//		{
//			return ResponseEntity.ok("Request recevied");
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request not found");
//		}
//	}

	@Override
	public ResponseEntity deleteBySenderIdANDReceiverId(Integer id, Integer id1) {
		connectionRepository.findBysenderidANDreceiverid(userRepository.findById(id).get(),userRepository.findById(id1).get());
		return ResponseEntity.ok("Deleted successfully");

	}



}

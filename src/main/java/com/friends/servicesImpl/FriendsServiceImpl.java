package com.friends.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.friends.entity.Connection;
import com.friends.entity.Friends;
import com.friends.repository.ConnectionRepository;
import com.friends.repository.FriendsRepository;
import com.friends.repository.UserRepository;
import com.friends.response.FriendsResponse;
import com.friends.services.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	ConnectionRepository connectionRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	FriendsRepository friendsRepository;

	@Override
	public ResponseEntity<String> findByReceiverId(Integer senderid, Integer recevierid) {
		Optional<Connection> connection = connectionRepository.findByreceiveridAndsenderid(
				userRepository.findById(senderid).get(), userRepository.findById(recevierid).get());
		if (!connection.isEmpty()) {
			Friends friends = new Friends();
			friends.setUser1(connection.get().getSenderid());
			friends.setUser2(connection.get().getReceiverid());
			friendsRepository.save(friends);
//			connectionRepository.deleteByreceiveridAndsenderid(senderid,recevierid);
			return ResponseEntity.ok("done");
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request not found");
		}
	}

	@Override
	public ResponseEntity<?> findByuser1(Integer userid) {
		
		List<Friends> friends = friendsRepository.findByuser1(userRepository.findById(userid).get());
		if(!friends.isEmpty())
		{
			return ResponseEntity.ok(friends);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Friend is not found");
				
	}


}

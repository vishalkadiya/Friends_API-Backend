package com.friends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.friends.services.ConnectionService;
import com.friends.services.FriendsService;

@RestController
@RequestMapping(value="/api/friend")
public class FriendController {
	
	@Autowired
	FriendsService friendService;
	
	@Autowired
	ConnectionService connectionService;
	
	
	@GetMapping("/acceptrequest/sender/{senderid}/reciever/{recieverid}")
	public ResponseEntity<?> findBySenderIdReceiverId(@PathVariable("senderid") Integer senderid,@PathVariable("recieverid") Integer recevierid) {
		return friendService.findByReceiverId(senderid,recevierid);
	}
	
	@GetMapping("/acceptrequest/user1/{userid}")
	public ResponseEntity<?> findByuserId(@PathVariable("userid") Integer userid) {
		return friendService.findByuser1(userid);
	}
}

package com.friends.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.friends.entity.User;
import com.friends.request.ConnectionRequest;
import com.friends.services.ConnectionService;
import com.friends.services.UserService;

@RestController
@RequestMapping(value = "/api/connection")
public class ConnectionController {

	@Autowired
	ConnectionService connectionService;
	
	@Autowired
	UserService userService;
		
	@PostMapping
	public ResponseEntity<Object> addConnection(@RequestBody @Valid ConnectionRequest connectionRequest,
			BindingResult bindingResult) {
		User senderId = userService.findById(connectionRequest.getSenderid());
		User reciverId = userService.findById(connectionRequest.getReceiverid());
		if (senderId != null && reciverId != null) {
			connectionService.save(senderId, reciverId);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");
		}
		if (bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage())
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}

		return ResponseEntity.ok("Request send");
	}

//	@GetMapping("/sendrequest/{id}")
//	public ResponseEntity<?> findBySenderId(@PathVariable("id") Integer id) {
//		return connectionService.findBySenderId(id);
//	}
//
//	@GetMapping("/acceptrequest/{id}")
//	public ResponseEntity<?> findByReceiverId(@PathVariable("id") Integer id) {
//		return connectionService.findByReceiverId(id);
//	}
	
	@DeleteMapping("rejectrequest/{senderid}/{receiverId}")
	public ResponseEntity deleteBySenderIdANDReceiverId(@PathVariable("senderid") Integer id,@PathVariable("receiverId") Integer id1) {
		connectionService.deleteBySenderIdANDReceiverId(id,id1);	
		return ResponseEntity.ok("Request Rejected");
	}
	


}

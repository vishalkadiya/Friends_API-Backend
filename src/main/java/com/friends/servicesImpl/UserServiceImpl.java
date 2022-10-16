package com.friends.servicesImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.friends.entity.User;
import com.friends.repository.UserRepository;
import com.friends.request.LoginRequest;
import com.friends.request.UserRequest;
import com.friends.services.UserService;
import com.friends.utils.RandomStringGenerator;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity save(UserRequest userRequest) {
		
		User user = new User(null, userRequest.getFirstname(),userRequest.getLastname(),userRequest.getAddress(),userRequest.getImage(),userRequest.getMobilenum(),userRequest.getEmail(), null, null, null, null);
		Optional<User> u = userRepository.findByEmail(userRequest.getEmail());
		
		if(!u.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already exsit");
		}
		
		return ResponseEntity.ok(userRepository.save(user));
	}
	@Override
	public ResponseEntity updateImage(MultipartFile file,Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isEmpty())
		{
			User u = user.get();
			u.setImage(file.getOriginalFilename());
			return ResponseEntity.ok(userRepository.save(u));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");
		}
	}
	@Override
	public User findById(Integer id) {
		User user = null;
		if(userRepository.findById(id).isPresent()) {
			user = userRepository.findById(id).get();
		}
		return user;
	}
	@Override
	public List<User> getAllData() {
		List<User> list = (List<User>)userRepository.findAll();
		return list;
	}
	
	@Override
	public ResponseEntity<List<User>> selecteddatabynativequery(String firstname) {
		return ResponseEntity.ok(userRepository.myNativeQuery(firstname));
	}
	
	
}
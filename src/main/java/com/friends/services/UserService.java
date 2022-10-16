package com.friends.services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.friends.entity.User;
import com.friends.request.LoginRequest;
import com.friends.request.UserRequest;

public interface UserService {

	ResponseEntity save(@Valid UserRequest userRequest);

	ResponseEntity updateImage(MultipartFile file, @Valid Integer id);

	User findById(Integer id);

	List<User> getAllData();

	ResponseEntity<List<User>> selecteddatabynativequery(String firstname);

//	ResponseEntity<List<User>> getmobileno(String mobileno);
//
//	ResponseEntity<List<User>> getemail(String email);

}

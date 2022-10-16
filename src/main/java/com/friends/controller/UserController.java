package com.friends.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.friends.entity.User;
import com.friends.request.LoginRequest;
import com.friends.request.UserRequest;
import com.friends.services.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Value("${download.file.path}")
    private String DOWNLOAD_FILE_PATH;
	
	@PostMapping
	public ResponseEntity addUser(@RequestBody @Valid UserRequest userRequest,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage())
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		return userService.save(userRequest);
	
	}
	
	@PutMapping(value = "/upload/{id}",consumes = "multipart/form-data")
	public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file,@PathVariable("id") @Valid Integer id){
		
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path path = Paths.get(DOWNLOAD_FILE_PATH+file.getOriginalFilename());
		
		try {
			byte[] bytes = file.getBytes();
			Files.write(path, bytes);
//			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//			System.out.println("test " +path);
			System.out.println("test " +path.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/files/download/")
//				.path(fileName)
//				.toUriString();
//		userRequest.setImage(file.getOriginalFilename());
		return userService.updateImage(file,id);
	}

	@GetMapping
	public ResponseEntity<List<User>> getData() {

		List<User> list = userService.getAllData();
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@GetMapping("get/{fname}")
	public ResponseEntity<List<User>> getData(@PathVariable("fname") String firstname) {	
		return userService.selecteddatabynativequery(firstname);	
	}
	
}
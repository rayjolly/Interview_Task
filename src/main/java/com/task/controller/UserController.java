package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.User;
import com.task.repository.UserRepository;
import com.task.service.UserService;

@RestController
@RequestMapping("/test")
public class UserController {

	private final UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// localhost:8080/users
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody User user) {
	    User savedUser = userRepository.save(user);

	    if (savedUser != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body("Data inserted to DataBase successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert data");
	    }
	}

	// localhost:8080/userData
	@GetMapping("/userData")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = userService.getAllUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}

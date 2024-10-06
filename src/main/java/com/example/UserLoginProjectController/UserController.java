package com.example.UserLoginProjectController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserLoginProjectEntity.User;
import com.example.UserLoginProjectService.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		userService.save(user);
		return "User registered successfully!";
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		User existingUser = userService.findByUsername(user.getUsername());
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			return "Login successful!";
		} else {
			return "Invalid username or password!";
		}
	}

}

package com.mkiats.controllers;

import com.mkiats.entities.User;
import com.mkiats.services.entityServices.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

	private final UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{user_id}")
	public User getUser(@PathVariable String user_id) {
		System.out.println(user_id);
		User theUser = userService.getUser(user_id);
		if (theUser == null) {
			throw new RuntimeException("User not found " + user_id);
		}
		return theUser;
	}
}
package com.blogging_site.practice.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging_site.practice.classes.User;
import com.blogging_site.practice.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserControllers {
	
	@Autowired
	private UserServices userService;
	
	
	@PostMapping("register")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
		
			User alreadyUser=userService.findUserWithEmail(user.getEmail());
			System.out.println(alreadyUser);
			if(alreadyUser==null) {
				String regsiterUser= userService.register(user);
				return new ResponseEntity<String>(regsiterUser.toString(), HttpStatus.CREATED);
			}else {
				return new ResponseEntity<String>("Already registered !Please login with the given email", HttpStatus.CONFLICT);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			String errorMessage=e.getMessage();
			return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
		try {
			
			return new ResponseEntity<String>( "ok", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("update-profile/{id}")
	public ResponseEntity<String> updateProfile(@PathVariable Long id, @RequestBody User user) {
		try {
			User userDetails= userService.getUser(id);
			if(userDetails != null) {
				User updatedUser=userService.updateProfile(id, user);
				return new ResponseEntity<String>( updatedUser.toString(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>( "User not found ", HttpStatus.GONE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("delete-account")
	public ResponseEntity<String> deleteAccount(@RequestBody Map<String ,String> credentials) {
		try {
			String email=credentials.get("email");
			String password=credentials.get("password");
			User userDetails= userService.findUserWithEmail(email);
			if(userDetails != null) {
				boolean passwordMatch= userDetails.getPassword().equals(password);
				boolean deleteUser= userService.deleteAccount(userDetails.getId());
				return new ResponseEntity<String>( "User deleted successfully", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>( "User not found", HttpStatus.GONE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("get-user/{id}")
	public ResponseEntity<String> getUser(@PathVariable Long id) {
		try {
			User userDetails= userService.getUser(id);
			if(userDetails != null) {
				return new ResponseEntity<String>(  userDetails.toString(), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>( "User not found", HttpStatus.GONE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

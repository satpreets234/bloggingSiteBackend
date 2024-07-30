package com.blogging_site.practice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blogging_site.practice.classes.User;

@Service
public interface UserServices{

	String login();
	String register(User user);
	User updateProfile(Long id,User user);
	boolean deleteAccount(Long id);
	User findUserWithEmail(String email);
	User getUser(Long id);
}

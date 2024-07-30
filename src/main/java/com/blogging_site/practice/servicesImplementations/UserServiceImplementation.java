package com.blogging_site.practice.servicesImplementations;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blogging_site.practice.classes.User;
import com.blogging_site.practice.entities.UserEntity;
import com.blogging_site.practice.repositries.UserRepository;
import com.blogging_site.practice.services.UserServices;

@Service
public class UserServiceImplementation implements UserServices {

	@Autowired
	private UserRepository userRepository;
	@Override
	public String login() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		
		try {
			UserEntity newUser= new UserEntity();
			BeanUtils.copyProperties(user, newUser);
			 userRepository.save(newUser);
			System.out.println(newUser.getEmail());
			return "register successfully";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public boolean deleteAccount(Long id) {
		// TODO Auto-generated method stub
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public User updateProfile(Long id,User user) {
		// TODO Auto-generated method stub
		try {
			UserEntity userEntity= userRepository.findById(id).get();
			
			userEntity.setEmail(user.getEmail());
			userEntity.setPassword(user.getPassword());
			userEntity.setUsername(user.getUsername());
			userRepository.save(userEntity);
			
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public User findUserWithEmail(String email) {
		// TODO Auto-generated method stub
		try {
			UserEntity userEntity= userRepository.findByEmail(email);
			User newUser= new User();
			BeanUtils.copyProperties(userEntity, newUser);
			return newUser;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		try {
			UserEntity user= userRepository.findById(id).get();
			User newUser= new User();
			BeanUtils.copyProperties(user, newUser);
			return newUser;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
}

package com.blogging_site.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging_site.practice.classes.Post;
import com.blogging_site.practice.classes.User;
import com.blogging_site.practice.services.PostServices;
import com.blogging_site.practice.services.UserServices;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("post")
public class PostControllers {

	@Autowired
	private PostServices postServices;
	private UserServices userServices;
	@PostMapping("create-post")
	public ResponseEntity<String> createPost(@RequestBody Post post) {
		try {
			Post createdPost= postServices.createPost(post);
			if(createdPost != null) {
				return new ResponseEntity<String>("Post created successfully", HttpStatus.CREATED);
			}else {
				return new ResponseEntity<String>("Cannot create post", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@GetMapping("get-post/{postId}")
	public ResponseEntity<String> getPost(@PathVariable Long postId) {
		try {
			Post postDetails= postServices.getPost(postId);
			if(postDetails != null) {
				return new ResponseEntity<String>(postDetails.toString(), HttpStatus.CREATED);
			}else{
				return new ResponseEntity<String>("Post not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("get-all-post/{userId}")
	public ResponseEntity<?> getAllPost(@PathVariable Long userId) {
		try {
			User userDetails= userServices.getUser(userId);
			if(userDetails != null) {
				List<Post> allUserPost=postServices.getAllPosts(userId);
				return new ResponseEntity<List<Post>>(allUserPost, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("update-post/{postId}")
	public ResponseEntity<String> putMethodName(@PathVariable Long postId, @RequestBody Post postDetails) {
		//TODO: process PUT request
		
		try {
			Post postDetail=postServices.getPost(postId);
			if(postDetail != null) {
				Post updatePost= postServices.updatePost(postId, postDetails);
				return new ResponseEntity<>(updatePost.toString(),HttpStatus.ACCEPTED);
			}else{
				return new ResponseEntity<>("Post not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@DeleteMapping("delete-post/{postId}")
	public ResponseEntity<String> deletePost(@PathVariable Long postId) {
		try {
			Post postDetail=postServices.getPost(postId);
			if(postDetail != null) {
				Boolean deletePost= postServices.deletePost(postId);
				if(deletePost) {
					return new ResponseEntity<>("Post deleted successfully",HttpStatus.ACCEPTED);
				}else {
					return new ResponseEntity<>("Cannot delete post",HttpStatus.BAD_REQUEST);
				}
			}else{
				return new ResponseEntity<>("Post not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

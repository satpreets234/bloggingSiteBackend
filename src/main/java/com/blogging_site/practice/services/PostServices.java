package com.blogging_site.practice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogging_site.practice.classes.Post;

@Service
public interface PostServices {

	Post createPost(Post post);
	Post getPost(Long id);
	boolean deletePost(Long id);
	Post updatePost(Long id, Post post);
	List<Post> getAllPosts(Long userId);
}

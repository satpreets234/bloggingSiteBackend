/**
 * 
 */
package com.blogging_site.practice.servicesImplementations;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging_site.practice.classes.Post;
import com.blogging_site.practice.entities.PostEntity;
import com.blogging_site.practice.repositries.PostRepository;
import com.blogging_site.practice.services.PostServices;

/**
 * 
 */
@Service
public class PostServiceImplementation implements PostServices {

	
	@Autowired
	private PostRepository postRepository;
	@Override
	public Post createPost(Post post) {
		// TODO Auto-generated method stub
		try {
			PostEntity postEntity=new PostEntity();
			BeanUtils.copyProperties(post, postEntity);
			postRepository.save(postEntity);
			return post;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Post getPost(Long id) {
		// TODO Auto-generated method stub
		try {
			PostEntity postDetail= postRepository.findById(id).get();
			Post postObj= new Post();
			BeanUtils.copyProperties(postDetail, postObj);
			return postObj;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deletePost(Long id) {
		// TODO Auto-generated method stub
		try {
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Post updatePost(Long id, Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPosts(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

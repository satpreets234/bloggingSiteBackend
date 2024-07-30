package com.blogging_site.practice.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogging_site.practice.entities.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity , Long> {

}

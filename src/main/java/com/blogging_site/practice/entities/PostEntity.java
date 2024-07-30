package com.blogging_site.practice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_posts")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne()
	private UserEntity user_id;
//	private Long category_id;
	private String title;
	private String content;
//	private Byte[] image;
}

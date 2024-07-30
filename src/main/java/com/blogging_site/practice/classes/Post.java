package com.blogging_site.practice.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	private Long id;
	private User user;
//	private Long category_id;
	private String title;
	private String content;
//	private Byte[] image;

	
}

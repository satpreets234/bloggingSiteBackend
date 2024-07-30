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
public class Category {
	
	private int id;
	private String category_name;
	private boolean isActive;
}

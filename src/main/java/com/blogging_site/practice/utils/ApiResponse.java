package com.blogging_site.practice.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
		private String message;
		private boolean success;
		private int statusCode;
		private List<Object> data;
		
		
}

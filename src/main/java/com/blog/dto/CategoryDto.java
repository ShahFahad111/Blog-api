package com.blog.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotNull
	@Size(min=4,message = "Minimum Length Should be 4")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min=10, max =30,message = "Category Description Should be of length between 10 and 30")
	private String categoryDescription;
}

package com.blog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min=3,message = "Name must be atleast 3 chars!!")
	private String name;
	
	@Email
	@NotEmpty(message = "Invalid Email address")
	private String email;
	
	@NotEmpty
	@Size(min=4,max = 10, message = "Password must be between 4 and 10 char size")
	private String password;
	
	@NotNull
	private String about;
}

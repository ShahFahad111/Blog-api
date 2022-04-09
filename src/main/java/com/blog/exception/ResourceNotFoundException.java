package com.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
	String resourceName;
	String filedName;
	long fieldValue;
}

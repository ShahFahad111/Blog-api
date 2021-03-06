package com.blog.service;

import java.util.List;

import com.blog.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto,Integer id);

	UserDto getUserById(Integer id);

	List<UserDto> getAllUsers();

	void deleteUser(Integer id);
}

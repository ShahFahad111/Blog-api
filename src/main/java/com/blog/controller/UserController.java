package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/")
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
		UserDto createdUserDto = userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto,@PathVariable("userId")Integer id){
		UserDto updateUser = userService.updateUser(userDto, id);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") @Valid Integer id){
		UserDto userById = userService.getUserById(id);
		return new ResponseEntity<>(userById,HttpStatus.OK);
	}
	
	@GetMapping(value="/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") @Valid Integer id){
		userService.deleteUser(id);
		return new ResponseEntity("UserId " + id + " Deleted",HttpStatus.OK);
	}
}

package com.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.UserDto;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.User;
import com.blog.repo.UserRepo;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = dtoToUser(userDto);
		User savedUser = userRepo.save(user);
		return userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto,Integer id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		User user1 = userRepo.save(user);
		return userToDto(user1);
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		return userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> collect = users.stream().map(e->userToDto(e)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		userRepo.delete(user);
	}

	private User dtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		/*
		 * User user = new User(); user.setId(userDto.getId());
		 * user.setName(userDto.getName()); user.setEmail(userDto.getEmail());
		 * user.setPassword(userDto.getPassword()); user.setAbout(userDto.getAbout());
		 */
		return user;
	}
	
	private UserDto userToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		/*
		 * UserDto userDto = new UserDto(); userDto.setId(user.getId());
		 * userDto.setName(user.getName()); userDto.setEmail(user.getEmail());
		 * userDto.setPassword(user.getPassword()); userDto.setAbout(user.getAbout());
		 */
		return userDto;
	}
}

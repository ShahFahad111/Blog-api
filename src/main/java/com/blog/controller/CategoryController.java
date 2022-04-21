package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.blog.dto.CategoryDto;
import com.blog.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto){
		return new ResponseEntity<>(categoryService.createCategory(categoryDto),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody @Valid CategoryDto categoryDto,@PathVariable("categoryId")Integer categoryId){
		CategoryDto catDto = categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<>(catDto,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId")Integer categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>("Category Deleted",HttpStatus.OK);
	}
	
	@GetMapping(value = "/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Integer categoryId){
		CategoryDto categoryDto = categoryService.getCategory(categoryId);
		return new ResponseEntity<>(categoryDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<>(allCategory,HttpStatus.OK);
	}
}

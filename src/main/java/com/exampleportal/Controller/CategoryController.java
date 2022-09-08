package com.exampleportal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.Category;
import com.exampleportal.Services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		Category savedcategory=this.categoryService.addCategory(category);
		return ResponseEntity.ok(savedcategory);
		
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryId") int categoryId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.getCategory(categoryId));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
		
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable int categoryId){
		
		this.categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body("Category deleted with id :"+categoryId);
	}
	
	

}

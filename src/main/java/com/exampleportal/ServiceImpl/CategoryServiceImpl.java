package com.exampleportal.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.Category;
import com.exampleportal.Exception.ResourceNotFoundException;
import com.exampleportal.Repository.CategoryRepository;
import com.exampleportal.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
   
	@Autowired
	private CategoryRepository categoryRepo;
	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return this.categoryRepo.findAll();
	}

	@Override
	public Category getCategory(int categoryId) {
		
		return this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",""+categoryId));
	}

	@Override
	public void deleteCategory(int categoryId) {

       this.categoryRepo.deleteById(categoryId);
		
	}

}

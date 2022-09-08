package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public List<Category> getAllCategory();
	
	public Category getCategory(int categoryId);
	
	public void deleteCategory(int categoryId);

}

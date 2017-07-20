package com.dave.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dave.products.models.Category;
import com.dave.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	public void addCategory(Category category){
		categoryRepository.save(category);
	}
	public Category findCategoryById(long id) {
		return categoryRepository.findOne(id);
	}
	public void updateCategory(Category cat) {
		categoryRepository.save(cat);
	}
	public List<Category> allCategories() {
		return (List<Category>) categoryRepository.findAll();
	}
}

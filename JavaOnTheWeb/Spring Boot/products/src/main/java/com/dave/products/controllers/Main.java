package com.dave.products.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dave.products.models.Category;
import com.dave.products.models.Product;
import com.dave.products.services.CategoryService;
import com.dave.products.services.ProductService;

@Controller
public class Main {
	private ProductService productService;
	private CategoryService categoryService;
	public Main(ProductService productService, CategoryService categoryService){
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/")
	public String index(){
		return "index.jsp";
	}
	@RequestMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product){
		return "newproduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
		if (result.hasErrors()){
			return "newproduct.jsp";
		}
		else{
			productService.addProduct(product);
			return "redirect:/";
		}
	}
	@RequestMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category category){
		return "newcategory.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
		if (result.hasErrors()){
			return "newcategory.jsp";
		}
		else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}
	@RequestMapping("/categoryProduct/{categoryId}")
	public String addProductToCategory(@PathVariable("categoryId") long id, @ModelAttribute("category") Category category, Model model){
		//retrieve category object
		Category cat = categoryService.findCategoryById(id);
		System.out.println(cat);
		//add category object to model so we can access name and id for our POST route 
		model.addAttribute("cat", cat);
		List<Product> products = productService.allProducts();
		System.out.println(products);
		model.addAttribute("allproducts", products);
		return "showcategory.jsp";
	}
	@PostMapping("/categoryProduct/{categoryId}")
	public String addProductToCategory(@PathVariable("categoryId") long id, @ModelAttribute("category") Category category, BindingResult result){
		long productId = Long.parseLong((String) result.getFieldValue("products"));
		System.out.println(productId);
		Category cat = categoryService.findCategoryById(id);
		Product prod = productService.findProductById(productId);
		System.out.println(cat.getProducts());
		List<Product> list = cat.getProducts();
		list.add(prod);
		System.out.println(list);
		cat.setProducts(list);
		System.out.println(cat.getProducts());
		categoryService.updateCategory(cat);
		return "redirect:/"; 
	}
	@RequestMapping("/productCategory/{productId}")
	public String addCategoryToProduct(@PathVariable("productId") long id, @ModelAttribute("product") Product product, Model model){
		Product prod = productService.findProductById(id);
		model.addAttribute("product", prod);
		
		//exclude categories the product already has;
		List<Category> productsCurrentCategories = prod.getCategories();
		List<Category> allTheCategories = categoryService.allCategories();
		ArrayList<Category> finalCategoriesList = new ArrayList<>();
		for (int i = 0; i < allTheCategories.size(); i++){
			int count = 0;
			for (Category category : productsCurrentCategories){
				if (category.getName().equals(allTheCategories.get(i).getName())){
					i++;
					break;
				}
				count++;
			}
			if (count == 0 || count == productsCurrentCategories.size()){
				finalCategoriesList.add(allTheCategories.get(i));
			}
		}
		model.addAttribute("allcategories", finalCategoriesList);
		return "showproduct.jsp";
		
	}
	
	
	
	
	
	
}

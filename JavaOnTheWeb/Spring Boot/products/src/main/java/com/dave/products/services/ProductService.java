package com.dave.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dave.products.models.Product;
import com.dave.products.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	public void addProduct(Product product){
		productRepository.save(product);
	}
	public List<Product> allProducts() {
		return (List<Product>) productRepository.findAll();
	}
	public Product findProductById(long productId) {
		// TODO Auto-generated method stub
		return productRepository.findOne(productId);
	}
}

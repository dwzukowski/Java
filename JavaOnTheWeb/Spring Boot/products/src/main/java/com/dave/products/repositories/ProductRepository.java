package com.dave.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dave.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}

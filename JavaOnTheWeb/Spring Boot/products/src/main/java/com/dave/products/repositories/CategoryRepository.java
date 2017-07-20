package com.dave.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dave.products.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}

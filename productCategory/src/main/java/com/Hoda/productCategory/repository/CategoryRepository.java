package com.Hoda.productCategory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.productCategory.models.Category;
import com.Hoda.productCategory.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
//	List<Category> findByCategoryIdIsNull();
}

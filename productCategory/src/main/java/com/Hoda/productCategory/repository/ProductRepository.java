package com.Hoda.productCategory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.productCategory.models.Category;
import com.Hoda.productCategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
List<Product>findAll();
List<Product> findByCategoriesNotContains(Category category);
//List<Product> findByProductIdIsNull();
}

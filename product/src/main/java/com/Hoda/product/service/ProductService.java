package com.Hoda.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hoda.product.models.Category;
import com.Hoda.product.models.Product;
import com.Hoda.product.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
private ProductRepository prRepo;

public List<Product> findAllPro(){
	return prRepo.findAll();
}
public Product findById(Long id) {
	Product product=prRepo.findById(id).orElse(null);
	return product;
}

public Product creatpro(Product product) {
	return prRepo.save(product);
}
public List<Product> notin(Category category){
	List<Product> prod=prRepo.findByCategoriesNotContains(category);
	return prod;
}
public void addproToCate(Product product,Category category) {
	List<Category> categories=product.getCategories();
	categories.add(category);
	prRepo.save(product);
}
}

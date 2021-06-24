package com.Hoda.productCategory.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.Hoda.productCategory.models.Category;
import com.Hoda.productCategory.models.Product;
import com.Hoda.productCategory.repository.ProductRepository;

@Service
public class ProductServices {
private final ProductRepository productRepository;

public ProductServices(ProductRepository productRepository) {
	this.productRepository = productRepository;
}
public List<Product > allproduct() {
    return productRepository.findAll();
}

public Product creatpro(Product b) {
    return productRepository.save(b);
}

public Product selectbyId (Long id) {
    Optional< Product> optiocate = productRepository.findById(id);
    if(optiocate.isPresent()) {
        return optiocate.get();
    } else {
        return null;
    }
} 
//**********
//public List<Product> allNullprodcts() {
//	return productRepository.findByCategoryIdIsNull();
//}
//************************
public void change(Product product, Category category) {
	List<Category> catlist = product.getCategories();
	catlist.add(category);
	product.setCategories(catlist);
	productRepository.save(product);
	
}

public List<Product> notin(Category category) {
	List<Product> cat = productRepository.findByCategoriesNotContains(category);
	
	return cat;
}
}

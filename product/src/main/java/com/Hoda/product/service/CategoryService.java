package com.Hoda.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hoda.product.models.Category;
import com.Hoda.product.models.Product;
import com.Hoda.product.repository.CategoryRepository;

@Service
public class CategoryService {
@Autowired
private CategoryRepository catrepo;

//	private final CategoryRepository catrepo;
//	
//public CategoryService(CategoryRepository catrepo) {
//	super();
//	this.catrepo = catrepo;
//}

public List<Category> findAllcat(){
	return catrepo.findAll();
}
public Category findcatById(Long id) {
	Category category=catrepo.findById(id).orElse(null);
	return  category;
}
public Category creatcat(Category category) {
	return catrepo.save(category);
}
public List<Category> notin(Product product){
	List<Category> catego=catrepo.findByProductsNotContains(product);
	return catego;
}
public void addcatToPro(Product product, Category category) {
	List<Product> products=category.getProducts();
	products.add(product);
	catrepo.save(category);
}

}

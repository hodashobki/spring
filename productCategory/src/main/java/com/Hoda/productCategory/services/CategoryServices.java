package com.Hoda.productCategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.productCategory.models.Category;
import com.Hoda.productCategory.models.Product;
import com.Hoda.productCategory.repository.CategoryRepository;

@Service
public class CategoryServices {
private final CategoryRepository categoryRepository;

public CategoryServices(CategoryRepository categoryRepository) {
	this.categoryRepository = categoryRepository;
}
public List<Category > allCategory() {
    return categoryRepository.findAll();
}
public Category creatcate(Category b) {
    return categoryRepository.save(b);
}
public Category finddojo(Long id) {
    Optional< Category> optcate = categoryRepository.findById(id);
    if(optcate.isPresent()) {
        return optcate.get();
    } else {
        return null;
    }
} 
//****
public void createproduct(Product product, Category category) {
	
	category.addproducts(product);
	
}

public List<Category> notin(Product product) {
	
	List<Category> cat = categoryRepository.findByProductsNotContains(product);
	
	return cat;
}
public void change(Product product, Category category) {
	
	List<Product> prolist = category.getProducts();
	prolist.add(product);
	category.setProducts(prolist);
	categoryRepository.save(category);
	}
//_______________

}

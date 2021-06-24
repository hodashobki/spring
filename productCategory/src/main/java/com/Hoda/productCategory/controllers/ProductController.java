package com.Hoda.productCategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hoda.productCategory.models.Category;
import com.Hoda.productCategory.models.Product;
import com.Hoda.productCategory.repository.CategoryRepository;
import com.Hoda.productCategory.services.CategoryServices;
import com.Hoda.productCategory.services.ProductServices;

@Controller
public class ProductController {
private final ProductServices productServices;
private final CategoryServices categoryServices;
public ProductController(ProductServices productServices, CategoryServices categoryServices) {
	this.productServices = productServices;
	this.categoryServices = categoryServices;
}
@RequestMapping("")
public String index() {
	return "index.jsp";
}
//****************Product
@RequestMapping("/products/new")
public String newpro(@ModelAttribute("product") Product product) {
	return "product.jsp";
}
@RequestMapping(value="/products/new", method =RequestMethod.POST)
public String createStudent (@Valid@ModelAttribute("product") Product product, BindingResult result) {
	
	if(result.hasErrors() ) {
		return "product.jsp";
	}
	productServices.creatpro(product);
	return "redirect:/";
}
//view category and add them(below is wrong)
//@RequestMapping("/products /{id}")
//public String person(@PathVariable("id") Long id, Model model) {
//	Product product = productServices.selectbyId(id);
//
//	model.addAttribute("product",product);
//
//	return "viewp.jsp";
//}

//******************add Category

@RequestMapping("/category/new")
public String newpro(@ModelAttribute("category") Category category) {
	return "cate.jsp";
}
@RequestMapping(value="/category/new", method =RequestMethod.POST)
public String creatCate (@Valid@ModelAttribute("category") Category category, BindingResult result) {
	
	if(result.hasErrors() ) {
		return "cate.jsp";
	}
	categoryServices.creatcate(category);
	return "redirect:/";
}
//*************************
@RequestMapping("/products/{id}")
public String product(@PathVariable("id") Long id, Model model) {
	Product product = productServices.selectbyId (id);
	List<Category> categories = categoryServices.notin(product);
	model.addAttribute("product", product);
	model.addAttribute("categories", categories);
	return "viewp.jsp";
}

@RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
public String productad(@RequestParam(value = "category") Long categoryid, @PathVariable("id") Long id) {
	Product product = productServices.selectbyId (id);
	Category category = categoryServices.finddojo(categoryid);
	categoryServices.change(product, category);
	return ("redirect:/products/"+id);
}

@RequestMapping("/categories/{id}")
public String category(@PathVariable("id") Long id, Model model) {
	Category category = categoryServices.finddojo(id);
	List<Product> products = productServices.allproduct();
	model.addAttribute("category", category);
	model.addAttribute("products", products);
	return "viewc.jsp";
}

@RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
public String categoryad(@RequestParam(value = "product") Long productid, @PathVariable("id") Long id) {
	Category category = categoryServices.finddojo(id);
	Product product = productServices.selectbyId(productid);
	productServices.change(product, category);
	return ("redirect:/categories/"+id);
}
}

package com.Hoda.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hoda.product.models.Category;
import com.Hoda.product.models.Product;
import com.Hoda.product.service.CategoryService;
import com.Hoda.product.service.ProductService;

@Controller
public class ProductController {
@Autowired
private CategoryService catserv;
 @Autowired 
 private ProductService proserv;
   @RequestMapping("")
   public String index() {
	   return "index.jsp";
   }
   @RequestMapping("/products/new")
   public String product(@ModelAttribute("product") Product product ) {
	   return "product.jsp";
   }
   @PostMapping("/products/new")
   public String newpro(@ModelAttribute("product") Product product, BindingResult result) {
	   if(result.hasErrors() ) {
			return "product.jsp";
		}
	   proserv.creatpro(product);
	   return "redirect:/";
	   
   }
//   Category
   @RequestMapping("/category/new")
   public String category(@ModelAttribute("category")Category category) {
	   return "category.jsp";
   }
   @PostMapping("/category/new")
   public String newcat(@ModelAttribute("category")Category category,BindingResult result) {
   if(result.hasErrors()) {
	   return "category.jsp";
   }
   catserv.creatcat(category);
   return "redirect:/";
   }
//   view************
   @RequestMapping("/products/{id}")
   public String viewpro(@PathVariable("id")Long id,Model model) {
	   Product product= proserv.findById(id);
	   List<Category> category =catserv.notin(product);
//	  List<Category> category=catserv.findcatById(catId);
	   model.addAttribute("category", category);
	   model.addAttribute("product", product);
	   return "viewpro.jsp";
   }
   @PostMapping("/products/{id}")
   public String viewpro(@RequestParam("category")Long catId ,@PathVariable("id")Long id,Model model) {
	   Product product=proserv.findById(id);
	   Category category=catserv.findcatById(catId);
	   catserv.addcatToPro(product, category);
	   return "redirect:/products/"+id;
   }
   @RequestMapping("/category/{id}")
   public String viewcat(@PathVariable("id")Long id ,Model model) {
	   Category category=catserv.findcatById(id);
	   List<Product> product=proserv.notin(category);
	   model.addAttribute("category", category);
	   model.addAttribute("product", product);
	   return "viewcat.jsp";
	   
   }
   @PostMapping("/category/{id}")
   public String viewcate(@RequestParam("product")Long proid,@PathVariable("id")Long id,Model model) {
	   Product product=proserv.findById(proid);
	   Category category=catserv.findcatById(id);
	   proserv.addproToCate(product,category);
	   return "redirect:/category/"+id;
	   
   }
}

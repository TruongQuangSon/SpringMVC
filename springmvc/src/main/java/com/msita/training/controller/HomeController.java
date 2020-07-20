package com.msita.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.database.ProductDAO;
import com.msita.training.entity.Product;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value= "loadProducts",method = RequestMethod.GET)
	@ResponseBody
	public List<Product> loadProducts() {
		return productDAO.getProducts();
	}
}

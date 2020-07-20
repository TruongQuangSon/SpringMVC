package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.msita.training.database.ProductDAO;

@Controller
@RequestMapping("/viewDetail")
public class ProductDetailController {
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewDetail(@RequestParam("productId") int id,ModelMap model) {
		model.addAttribute("product", productDAO.getProduct(id));
		return "detail";
	}
}

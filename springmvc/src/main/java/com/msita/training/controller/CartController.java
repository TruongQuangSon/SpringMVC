package com.msita.training.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.database.ProductDAO;
import com.msita.training.entity.Product;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String cart(ModelMap model,HttpServletRequest request) {
		List<Product> lstProductInCart = new ArrayList<>();
		Map<Integer,Integer> mapCart=(Map<Integer, Integer>) request.getSession().getAttribute("cart");
		if(mapCart!=null) {
			for(Integer product:mapCart.keySet()) {
				Product prod=productDAO.getProduct(product);
				prod.setQuantity(mapCart.get(product));
				lstProductInCart.add(prod);
			}
			model.addAttribute("lstProduct",lstProductInCart);
		}
		return "cart";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="add")
	//@ResponseBody
	public String add(@RequestParam("productId") int product,
			@RequestParam("quantity") int quantity,HttpServletRequest request) {
		if(request.getSession().getAttribute("cart")==null) {
			Map<Integer,Integer> mapCart= new HashMap<>();
			mapCart.put(product, quantity);
			request.getSession().setAttribute("cart", mapCart);
		}else {
			Map<Integer,Integer> mapCart=(Map<Integer, Integer>) request.getSession().getAttribute("cart");
			if(mapCart.containsKey(product)) {
				int quantityAdd=mapCart.get(product);
				quantityAdd+=quantity;
				mapCart.replace(product, quantityAdd);
			}else {
				mapCart.put(product, quantity);
			}
		}
		
		return "redirect:/cart";
	}
}

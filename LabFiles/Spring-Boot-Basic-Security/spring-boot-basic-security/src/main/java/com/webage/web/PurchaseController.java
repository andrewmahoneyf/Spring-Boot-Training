package com.webage.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webage.domain.Purchase;
import com.webage.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;

	@GetMapping("/index.html")
	public String getIndex() {
		System.out.println("getIndex was called");
		return "/index";
	}
	
	@GetMapping("/") 
	public String getRoot() {
		return "redirect:/index.html";
	}
	
	@ModelAttribute("date")
	public Date getDate() {
		return new Date();
	}
	
	@GetMapping("/addEditPurchase") 
	public String showAddForm() {
		return "/addEditPurchase";
	}
	
	@RequestMapping("/browse")
	public ModelAndView browsePurchases() {
		Collection<Purchase> list =
			purchaseService.findAllPurchases();
		return new ModelAndView("browsePurchases",
			 "purchaseList", list);
	}
}

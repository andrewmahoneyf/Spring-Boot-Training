package com.webage.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webage.dao.CustomersDAO;
import com.webage.domain.Customer;

@Controller
public class CustomersController {
	@Autowired
	private CustomersDAO customersDAO;

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
	
	@RequestMapping("/browseCustomers")
	public ModelAndView browseCustomers() {
		Collection<Customer> list =
			customersDAO.getAllCustomers();
		return new ModelAndView("browseCustomers",
			 "customers", list);
	}
}

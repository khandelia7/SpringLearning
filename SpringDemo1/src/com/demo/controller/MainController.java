package com.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.db.DB;
import com.demo.model.Bank;
import com.demo.model.Customer;
import com.demo.model.User;
import com.demo.service.BankService;
import com.demo.service.CustomerService;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService; // !!!!!! Very Important 1 !!!!!!

	@Autowired
	private BankService bankService;

	@Autowired
	private DB db;

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("msg", "Hi indexPage...!");
		model.addAttribute("list", db.fetchAllUser());
		return "index";
	}

	@RequestMapping("/welcome")
	public ModelAndView showWelcome(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		String msg = request.getParameter("msg");
		mav.addObject("msg", msg);

		// if i want to display 3 customer in welcome file...
		// DB fetch all info, and save in an object. (3)
		// List and add all 100 objects to the list
		// CustomerService customerService =new CustomerService();
		// Don't make PoJo here. !!!!!! Very Important 1 !!!!!!
		Bank bank = bankService.fetchBank();
		ArrayList<Customer> list = customerService.fetchCustomers();
		bank.setblist(list);
		// In UI i will iterate through this list...
		mav.addObject("bank", bank);

		mav.setViewName("welcome");
		return mav;
	}

	// This is a sign-up without spring
	@RequestMapping("/sign-up")
	public String showSignUp() {
		return "sign-up";
	}

	// This is a process sign-up without spring
	@RequestMapping("/process-sign-up")
	public String processSignUp(HttpServletRequest request) {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		User u = new User();
		u.setName(name);
		u.setUsername(username);
		u.setPassword(password);
		u.setRepassword(repassword);
		// validation
		// send user object to DB and save it in DB
		// User: mapped to: User Table
		return "login";
	}

	// This is a sign-up with Spring
	@RequestMapping("/sign-up-spring")
	public String showSignUpWithSpring(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		// user object is attached as request scope in
		// sign-up-spring jsp page
		return "sign-up-spring";
	}

	// This is a process sign-up with spring
	@RequestMapping("/process-sign-up-spring")
	public String processSignUpSpring(@Valid User user, BindingResult result) {
		// @ModelAttribute is use for older version (before User user)
		if (result.hasErrors()) {
			return "sign-up-spring";
		}
		System.out.println(user);
		// int status =
		db.insertUser(user); // 1 or 0
		return "login";
	}

}
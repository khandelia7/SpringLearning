package com.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.demo.model.Customer;
import com.demo.model.Status;
import com.demo.model.Subscription;

@Component
public class CustomerService {
	// DB fetch all info, and pass to controller
	// if needed add logic here

	private ArrayList<Customer> list; // !!!!!! Very Important 0 !!!!!!
	private Subscription s; // !!!!!! Very Important 0 !!!!!!
	private Status status; // !!!!!! Very Important 0 !!!!!!

	private void populateCustomer() {
		// {2000x}
		list = new ArrayList<Customer>(); // make object here because whenever method is call
		// then only memory allocation will be done
		// !!!!!! Very Important 0 !!!!!!
		Customer c1 = new Customer(1, "Akash", "Mumbai", 766600347);
		Customer c2 = new Customer(2, "Abhishek", "Delhi", 810894774);
		Customer c3 = new Customer(3, "Rajesh", "Jaipur", 932154392);
		Customer c4 = new Customer(4, "Anita", "Mumbai", 749836622);
		// {3000x, 4000x, 5000x}
		
		s = new Subscription();// make object here because whenever method is call
		// then only memory allocation will be done
		// !!!!!! Very Important 0 !!!!!!
		s.setId(1L);
		s.setPlan("Basic");
		c1.setSubscription(s);
		c2.setSubscription(s);
		c3.setSubscription(s);
		
		status=new Status();// make object here because whenever method is call
		// then only memory allocation will be done
		// !!!!!! Very Important 0 !!!!!!
		status.setStatus("Active");
		s.setStatus(status);

		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
	}

	public ArrayList<Customer> fetchCustomers() {
		populateCustomer();
		return this.list;
	}
}

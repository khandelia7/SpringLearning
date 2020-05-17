package com.demo.model;

import java.util.List;

public class Bank {

	private double id;
	private String name;

	// private Customer customer;
	// not possible as one has many customer
	private List<Customer> blist;

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getblist() {
		return blist;
	}

	public void setblist(List<Customer> blist) {
		this.blist = blist;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", blist=" + blist + "]";
	}

}

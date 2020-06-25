package com.tracker.service;

import java.util.List;

import com.tracker.entity.Customer;
import com.tracker.model.CustomerVo;

public interface ICustomerService {

	public List<Customer> getCustomers();
	
	public List<CustomerVo> getUsers();
	
	public Customer getCustomer(Long id);
}

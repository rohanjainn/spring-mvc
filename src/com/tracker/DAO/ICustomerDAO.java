package com.tracker.DAO;

import java.util.List;

import com.tracker.entity.Customer;
import com.tracker.model.CustomerVo;

public interface ICustomerDAO {

	List<Customer> getCustomers();
	
	List<CustomerVo> getUsers();
	
	public Customer getCustomerById(Long id);
}

package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracker.DAO.ICustomerDAO;
import com.tracker.entity.Customer;
import com.tracker.model.CustomerVo;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}
	
	
	@Override
	@Transactional
	public List<CustomerVo> getUsers() {
		
		
		List<Customer> customerList=null;
		List<CustomerVo> customerVo=null;
		
		try{
			customerList=customerDAO.getCustomers();
			if(!customerList.isEmpty())
			{
				customerVo=customerDAO.getUsers();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return customerVo;
	}


	@Override
	@Transactional
	public Customer getCustomer(Long id) {
		
		Customer customer=null;
		
		try{
			customer=customerDAO.getCustomerById(id);
			
			System.out.println(customer);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return customer;
	}

	
	
}

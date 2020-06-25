package com.tracker.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.Customer;
import com.tracker.model.CustomerVo;

@Component
public class CustomerDAO implements ICustomerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=session.createQuery("from Customer",Customer.class);
		
		List<Customer> customers=theQuery.getResultList();
		return customers;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<CustomerVo> getUsers() {
		
		Session session=sessionFactory.getCurrentSession();
		
		List<Object[]> objectList=null;
		List<CustomerVo> customeVoList=new ArrayList<CustomerVo>();
		CustomerVo customerVo=null;
		StringBuffer queryStr=new StringBuffer();
		queryStr.append("SELECT first_name,last_name,email from customer");
		
		Query theQuery=session.createNativeQuery(queryStr.toString());
		
		objectList=theQuery.getResultList();
		
		for(Object[] objectArray:objectList)
		{
			customerVo=new CustomerVo();
			//customerVo.setFirstName((String) objectArray[0]);
			//customerVo.setLastName((String) objectArray[1]);
			customerVo.setEmail((String) objectArray[2]);
			
			customeVoList.add(customerVo);
		}
		
		System.out.println(customeVoList);
		return customeVoList;
	}

	@Override
	public Customer getCustomerById(Long id) {
		
		Customer customer;
		Session session=sessionFactory.getCurrentSession();
		
		String qr="select * from customer where id=?1";
		Query query=session.createNativeQuery(qr,Customer.class);
		query.setParameter(1,id);
		//customer=(Customer) query.getResultList();
		customer=(Customer) query.getSingleResult();
		return customer;
	}

}

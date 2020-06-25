package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tracker.DAO.ICustomerDAO;
import com.tracker.entity.Customer;
import com.tracker.model.CustomerVo;
import com.tracker.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/")
	public String home()
	{
		return "main";
	}
	
	
	@RequestMapping("/list")
	public String listCustomers(Model model)
	{
		List<Customer> theCustomers=customerService.getCustomers();
		
		model.addAttribute("customers",theCustomers);
		return "CustomerList";
		
	}
	
	//ajax call

	@RequestMapping("/users")
	@ResponseBody
	public String users(
			Model model)
	{
		String customerData=null;
		List<CustomerVo> customerVoList=null;
		Gson gson=new Gson();
		
		try{
			List<CustomerVo> customerVoLi=new ArrayList<CustomerVo>();
			CustomerVo customerVoObj=new CustomerVo() ; 
			customerVoList=customerService.getUsers();
			String str=new String();
			String res=new String();
			StringBuilder sb=new StringBuilder();
			for(CustomerVo customerVo:customerVoList)
			{
				String s1="";
				/*String s1=customerVo.getEmail();
				res=s1+"\n"+res;*/
				 s1=customerVo.getEmail()+s1;
				sb.append(s1);
				//sb.append("test1\n");
				//sb.append("test2\n");
				sb.append("\n");
				
				
				//str=res+str;
				
				//str=str.concat(str);
				//str.concat(str);
				//str=str.concat(System.lineSeparator());
				//str=str.concat(str);
				
				//System.out.print(res);
				//customerVo.setEmail(str);
				//customerVoLi.add(customerVo);
				//customerVoObj.setEmail(res);
				
				//s.append(customerVo.getEmail());
				//s.append(String.format("%n", ""));
				//res=sb.toString();
				
			}
			String result=sb.toString();
			System.out.print(result);
			/*String[] parts=res.split("\n");
			System.out.print(parts);*/
			//customerVoObj.setEmail(s.toString());
			
		/*	String f=" ";
			for(String s:parts)
			{
				
				f=f+s;
			}*/
			customerVoObj.setEmail(result); 
			//customerData=gson.toJson(customerVoLi);
			customerData=gson.toJson(customerVoObj);
			System.out.print("JSON DATA :"+customerData);
			
			String[] spr=customerData.split("\\n");
			System.out.println("spliting :");
			String j="";
			for(String s: spr)
			{
				//j=j+s+"\n";
				System.out.println("s ="+s);
			}
			System.out.print("Data = "+j);
			System.out.println("JSON RESP"+customerData);
			model.addAttribute("users",customerVoList);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return customerData;
	}
	
	
	@RequestMapping("/addCustomerForm")
	public String addCustomer(Model model)
	{
		
		Customer thecustomer=new Customer();
		
		model.addAttribute("customer",thecustomer);
		return "addCustomerForm";
	}

	
	@PostMapping("/saveCustomer")
	public void saveCustomer(Model model,@RequestParam("firstname") String fname,
			@RequestParam("lastname") String lname,
			@RequestParam("email") String email)
	{
		System.out.println("first "+fname);
		//customerService.saveUser(fname,lname,email);
		//return "addCustomerForm";
	}
	
	@RequestMapping("/getCustomer")
	public void getCustomerById()
	{
		customerService.getCustomer(2l);
	}
}

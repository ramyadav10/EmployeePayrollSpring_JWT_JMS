package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.util.EmailListener;
import com.example.demo.util.EmailSenderService;
import com.example.demo.util.TokenUtil;

@Service
public class EmployeeService implements IEmployeeService
{
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Autowired
	TokenUtil tokenutil;
	
	@Autowired
	private EmailListener emaillistner;

	@Autowired
	private EmailSenderService sender;
	
	@Autowired
	private RestTemplate restTemplete;
	
	@Override
	public List<Employee> getEmployeePayRollData(String token) 
	{
		int id=tokenutil.decodeToken(token);
		Optional<Employee> isEmployeePresent=employeeRepository.findById(id);
		if(isEmployeePresent.isPresent()) {
			List<Employee> listEmployee=employeeRepository.findAll();
		return listEmployee;		
		}else {
		System.out.println("Exception ...Token not found!");	
		return null;	}	
		}

	
		@Override
		public List<Employee> getEmployeePayRollData1() 
		
		{
			
//			sender.sendEmail("ramyadav.now@gmail.com", "TestMail..!", "Hello..   http://localhost:8081/getAll");

		return employeeRepository.findAll();
			
	}

	@Override
	public Employee getEmployeePayRollData(int id)
	{
//		System.out.println("Test-step-01");
//		User user = restTemplete.getForObject(
//				"http://localhost:8082/user/62f2273ccd6be51b31882e27", User.class);
//		System.out.println(user.getFirstName());
		
		return employeeRepository.findById(id).orElse(null);
	}

//	@Override
//	public String addRecord(EmployeeDTO dto) throws Exception
//	{
//		System.out.println("Test-step-01");
//		Object user = restTemplete.getForObject("http://localhost:8082/user/62f2273ccd6be51b31882e27", Object.class);
////		
////		Object user = restTemplete.getForObject("http://localhost:8082/user/62f2270acd6be51b31882e26", Object.class);
////		System.out.println(user.toString());
////		if(user.equals(null)) {
////			throw new Exception("Invalid user id...please provide valid user id");
////
////		}else {
////			System.out.println("Test-step-03");
////		//	Object book = restTemplete.getForObject("http://localhost:9095/Book/getbook/3", Object.class);
////			System.out.println("Test-step-04");
////		//	if(book.equals(null)) {
////		//		throw new Exception("Invalid book id...please provide valid book id");
////		//	}else {
////				System.out.println("Test-step-05");
//		Employee entity = new Employee(dto);
//		employeeRepository.save(entity);
//		
//		
//		String token=tokenutil.createToken(entity.getId());
//		
//		
//		
//		
//		
//		
//		sender.sendEmail(entity.getName(), "TestMail..!", "Hello.. "+entity.getName()+ "  http://localhost:8081/retrive/"+token);
//		
//		
//		//emaillistner.sendMail();
//		//sender.sendEmail("ramhark.yadav@bridgelabz.com", "Test Email", "Registered SuccessFully1");
//		return token;
////		}
//		}
////	}

	@Override
	public Employee updateRecord(int id, EmployeeDTO dto) 
	{
		
		Employee entity = employeeRepository.findById(id).orElse(null);

		BeanUtils.copyProperties(dto, entity);
		employeeRepository.save(entity);
		
		return entity;
	}

	@Override
	public Employee deleteRecord(int id) 
	{
		
		employeeRepository.deleteById(id);
		
		return null;
	}
	
	
	@Override
	public String addRecord(EmployeeDTO dto) throws Exception
	{
//		User user = restTemplete.getForObject("http://localhost:8082/user/62f2270acd6be51b31882e26", User.class);
//		System.out.println(user.toString());
//		System.out.println(user.getFirstName());
//		if(user.equals(null)) {
//			throw new Exception("Invalid user id...please provide valid user id");
//
//		}else {
		Employee entity = new Employee(dto);
		employeeRepository.save(entity);		
		String token=tokenutil.createToken(entity.getId());
		sender.sendEmail(entity.getName(), "TestMail..!", "Hello.. "+entity.getName()+ "  http://localhost:8081/retrive/"+token);
		return token;
//		}
		}
	


}
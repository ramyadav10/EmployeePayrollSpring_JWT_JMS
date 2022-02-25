package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

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
		return employeeRepository.findAll();
			
	}

	@Override
	public Employee getEmployeePayRollData(int id)
	{
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public String addRecord(EmployeeDTO dto) 
	{
		Employee entity = new Employee(dto);
		employeeRepository.save(entity);
		String token=tokenutil.createToken(entity.getId());
		//emaillistner.sendMail();
		sender.sendEmail("ramhark.yadav@bridgelabz.com", "Test Email", "Registered SuccessFully1");
		return token;
	}

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

}

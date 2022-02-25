package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
public class EmpayController 
{
	@Autowired
	private IEmployeeService employeeService;
	
	@CrossOrigin
	@GetMapping(value = "/retrive/{token}")
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(@PathVariable String token)
	{
		List<Employee> entity = employeeService.getEmployeePayRollData(token);
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseDTO> getEmployeePayRollData()
	{
		List<Employee> entity = employeeService.getEmployeePayRollData1();
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/retrivel/{id}",method = RequestMethod.GET)
	public ResponseEntity<String> getEmployeePayRollData(@PathVariable int id)
	{
		Employee entity = employeeService.getEmployeePayRollData(id);
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (: for id"+id,entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	@CrossOrigin
	@PostMapping(value = "/insert")
	public ResponseEntity<String> addEmployeePayRollData(@Valid @RequestBody EmployeeDTO employeeDTO)
	{
		String entity = employeeService.addRecord(employeeDTO);
		ResponseDTO dto = new ResponseDTO("Record added successfully",entity);
		return new ResponseEntity(dto,HttpStatus.CREATED);
	}
	@CrossOrigin
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<String> updateEmployeePayRollData(@Valid @RequestBody EmployeeDTO employeeDTO,@PathVariable int id)
	{
		Employee entity = employeeService.updateRecord(id, employeeDTO);
		ResponseDTO dto = new ResponseDTO("Record updated successfully (: ",entity);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		Employee entity = employeeService.deleteRecord(id);
		ResponseDTO dto = new ResponseDTO("Record deleted successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
}
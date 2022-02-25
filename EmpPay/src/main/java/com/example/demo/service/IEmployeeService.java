package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;


public interface IEmployeeService
{
	public abstract List<Employee> getEmployeePayRollData(String token);
	public abstract Employee getEmployeePayRollData(int id);
	public abstract String addRecord(EmployeeDTO dto);
	public abstract Employee updateRecord(int id,EmployeeDTO dto);
	public abstract Employee deleteRecord(int id);
	List<Employee> getEmployeePayRollData1();
}
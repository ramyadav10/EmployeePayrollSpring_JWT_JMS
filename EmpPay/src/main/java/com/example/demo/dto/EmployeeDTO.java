package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class EmployeeDTO 
{
	@Pattern(regexp="^[A-Za-z]{3,}$",message="Enter the Valid Naming Convention")
	private String name;
	@Min(value=5000,message="Enter Salary more than 5000")
	private double salary;
	@NotNull
	private String department;

	public EmployeeDTO()
	{
		
	}

	public EmployeeDTO(String name, double salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
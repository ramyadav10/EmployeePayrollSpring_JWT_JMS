package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@RequiredArgsConstructor
@Data
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String department;
	private double salary;
	
	
	public Employee(EmployeeDTO dto) {
		this.name = dto.getName();
		this.salary = dto.getSalary();
		this.department = dto.getDepartment();
	}

	
	
}
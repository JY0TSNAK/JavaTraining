package com.sbi.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emps")
public class EmployeeController {
	
	List<Employee> staff = new ArrayList<Employee>();
	
	public EmployeeController() {
		System.out.println("EmployeeController() called..");
		Employee employee = new Employee(100,"King","President",LocalDate.of(1999, 1, 1),10000,30);
		Employee employee1 = new Employee(101,"Jack","Analyst",LocalDate.of(2000, 6, 12),5000,23);
		Employee employee2 = new Employee(102,"Jill","Accounts",LocalDate.of(2001, 5, 15),7000,25);
		Employee employee3 = new Employee(103,"Jane","Salesman",LocalDate.of(2002, 7, 20),6000,27);
		Employee employee4 = new Employee(104,"Julie","Clerk",LocalDate.of(2000, 6, 12),8000,23);
		
		staff.add(employee);
		staff.add(employee1);
		staff.add(employee2);
		staff.add(employee3);
		staff.add(employee4);
	}
	
	@RequestMapping("/getEmps") // http://localhost:8080/emps/getEmps
	public List<Employee> getAllEmployees() {
		System.out.println("/emps..");
		return staff;
		
	}

	@RequestMapping("/getEmp/{eno}") // http://localhost:8080/emps/getEmp/100
	public Employee getEmployeeObject(@PathVariable("eno") int employeeNumber) {
		System.out.println("/getEmp/eno..");
		boolean employeeFound = false;
		Employee employeeObject = null;
	
		for(int i=0;i<staff.size();i++) {
			employeeObject = staff.get(i);
			
			if(employeeObject.getEmployeeNumber() == employeeNumber) {
				employeeFound=true;
				break;
			}
		}
		
		if(employeeFound == true) {
			return employeeObject;
		}
		else {
			return null;
		}
		
	}
	
}

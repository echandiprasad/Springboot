package com.sb.restapi.service;

import java.util.List;

import com.sb.restapi.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(String id);

	Employee save(Employee employee);

	List<Employee> getEmployeeList();

}

package com.sb.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.restapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}



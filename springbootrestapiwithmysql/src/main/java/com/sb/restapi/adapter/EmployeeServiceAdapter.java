package com.sb.restapi.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.restapi.model.Employee;
import com.sb.restapi.repository.EmployeeRepository;
import com.sb.restapi.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceAdapter implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    
    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findOne(id);
    }

    @Transactional
    public Employee save(final Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

}
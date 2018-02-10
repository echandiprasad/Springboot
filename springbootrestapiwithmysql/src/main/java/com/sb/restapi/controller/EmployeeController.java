package com.sb.restapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.restapi.model.CustomException;
import com.sb.restapi.model.Employee;
import com.sb.restapi.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
    @RequestMapping(value = {"/getEmployeeList", "/"}, method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployeeList() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        if(employeeList.isEmpty()){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @RequestMapping(value = {"/getEmployee/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") String id) {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null){
        	return new ResponseEntity(new CustomException("Employee with id "+id+ " not found"),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employeeObj) {
    	
    	ResponseEntity<Employee> responseEntityNotFound = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    	Employee employee = employeeService.getEmployeeById(employeeObj.getId());
    	if(null != employee) {
    		return new ResponseEntity(new CustomException("Employee with id "+ employeeObj.getId() + " Already exists"),HttpStatus.ALREADY_REPORTED);
    	} 
    	
    	employee = employeeService.save(employeeObj);
    	
    	return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = {"/updateEmployee/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id", required = false) String id,
                                                   @RequestBody Employee employeeObj) {

        ResponseEntity<Employee> responseEntityNotFound = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        Employee employee = new Employee();

        if(null != id) {
            employeeObj.setId(id);
            employee = employeeService.getEmployeeById(id);
            if (null == employee) {
                return responseEntityNotFound;
            }
        }
        
        if(null == employeeObj.getEname()) employeeObj.setEname(employee.getEname());
        if(null == employeeObj.getCity()) employeeObj.setCity(employee.getCity());
        
        employee = employeeService.save(employeeObj);
        
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    
}
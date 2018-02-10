package com.sb.restapi;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.sb.restapi.model.Employee;

public class RestTemplateClient {

	public final static String REST_SERVICE_URI = "http://localhost:8085/empRest/api/";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllEmployees() {
		System.out.println("Testing getEmployeeList API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate
				.getForObject(REST_SERVICE_URI + "/getEmployeeList/",
						List.class);

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("id") + ", Name="
						+ map.get("name") + ", Age=" + map.get("city"));
				;
			}
		} else {
			System.out.println("No user exist----------");
		}
	}

	/* GET */
	private static void getEmployeeById() {
		System.out.println("Testing getEmployeeById API----------");
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(REST_SERVICE_URI
				+ "/getEmployee/0", Employee.class);
		System.out.println(emp);
	}

	/* POST */
	private static void saveEmployee() {
		System.out.println("Testing save Employee API----------");
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee("0", "Chandi", "Bengaluru");
		restTemplate.postForLocation(REST_SERVICE_URI + "/saveEmployee/", emp,
				Employee.class);

	}

	/* PUT */
	private static void updateEmployee() {
		System.out.println("Testing update Employee API----------");
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee("0", "Prasad", "Bangalore");
		restTemplate.put(REST_SERVICE_URI + "/updateEmployee/0", emp);

	}

	public static void main(String args[]) {
		saveEmployee();
		listAllEmployees();
		updateEmployee();
		listAllEmployees();
		getEmployeeById();

	}

}

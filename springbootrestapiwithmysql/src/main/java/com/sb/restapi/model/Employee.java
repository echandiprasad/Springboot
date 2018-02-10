package com.sb.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String id;

	private String ename;

	private String city;

	public Employee() {
	}

	public Employee(final String id, final String ename, final String city) {
		this.id = id;
		this.ename = ename;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "Employee{" + "id='" + id + '\'' + ", ename='" + ename + '\'' + ", city='" + city + '\'' + '}';
	}
	
	
}
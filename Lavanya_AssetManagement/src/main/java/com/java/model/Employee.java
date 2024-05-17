package com.java.model;

public class Employee {
	int employee_id;
	String name;
	String department;
	String email;
	String password;
	public Employee(int employee_id, String name, String department, String email, String password) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}
	
	public Employee(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + ", department=" + department + ", email="
				+ email + ", password=" + password + "]";
	}

}

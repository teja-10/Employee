package com.example.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class EmployeeEntity {
	
	@Column(name="employeename")
	private String employeeName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeid")
	private Integer employeeId;
	
	@Column(name="salary")
	private BigInteger salary;
	
	@Column(name="departmentcode")
	private Integer departmentCode;
	
	@Column(name="address")
	private String address ;
	
	@Column(name="phone")
	private String phone;
	
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public BigInteger getSalary() {
		return salary;
	}

	public void setSalary(BigInteger salary) {
		this.salary = salary;
	}

	public Integer getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public EmployeeEntity(String employeeName, Integer employeeId, BigInteger salary, Integer departmentCode,
			String address, String phone) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
		this.departmentCode = departmentCode;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeName=" + employeeName + ", employeeId=" + employeeId + ", salary=" + salary
				+ ", departmentCode=" + departmentCode + ", address=" + address + ", phone=" + phone + "]";
	}
}

	
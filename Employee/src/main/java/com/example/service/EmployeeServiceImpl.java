package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.dao.EmployeeDAO;
import com.example.entity.EmployeeEntity;
@Service
//public class EmployeeServiceImpl {

	//@Autowired
	//private EmployeeDAO employeeDAO;
	
	public class EmployeeServiceImpl {

	    private EmployeeDAO employeeDAO;

	    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }
	

	public int addEmployee(EmployeeEntity employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		EmployeeEntity emp= (EmployeeEntity)employeeDAO.save(employeeEntity);
		return emp.getEmployeeId();
	}

	public Collection<EmployeeEntity> getEmployeeDetails(){
		Collection<EmployeeEntity> collec =employeeDAO.findAll();
		List<EmployeeEntity> listEmployee = new ArrayList<EmployeeEntity> ();
		for (EmployeeEntity employeeEntity : collec) {
			EmployeeEntity employee=new EmployeeEntity();
			BeanUtils.copyProperties(employeeEntity, employee);
			listEmployee.add(employee);
		}
		return listEmployee;
	}
	
	public EmployeeEntity getEmployeeDetailByEmployeeId(int employeeId){
		EmployeeEntity employee =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employee= new EmployeeEntity();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	public EmployeeEntity deleteEmployee(int employeeId){
		EmployeeEntity employee =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employeeDAO.delete(employeeEntity);
			employee= new EmployeeEntity();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	
	public EmployeeEntity updateEmployee(EmployeeEntity employee){
		EmployeeEntity employee2 =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employee.getEmployeeId());
		if(employeeEntity!=null){
			//update operation
			BeanUtils.copyProperties(employee, employeeEntity);	
			employeeDAO.save(employeeEntity);
			
			//copying the properties back to EmployeeDTO Object 
			employee2= new EmployeeEntity();
			BeanUtils.copyProperties(employeeEntity, employee2);
		}
		return employee2;
	}
	
	
}


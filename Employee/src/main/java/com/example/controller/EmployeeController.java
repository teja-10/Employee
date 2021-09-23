package com.example.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EmployeeEntity;
import com.example.service.EmployeeServiceImpl;

@RestController
// extends @Controller
// object are automatically converted to JSON or XML
/*public class EmployeeContoller {
	
	//@Autowired
	private EmployeeServiceImpl employeeService;*/
//@Scheduled(fixedRate = 5000)
	public class EmployeeController {

	    private EmployeeServiceImpl employeeService;
	    public EmployeeController(EmployeeServiceImpl employeeService ) {
	        this.employeeService = employeeService;
	    }
	
	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EmployeeEntity>> getEmployeeDetails(){
		Collection <EmployeeEntity> listEmployeeEntity = employeeService.getEmployeeDetails();
		System.out.println(listEmployeeEntity);
		return new ResponseEntity<Collection<EmployeeEntity>>(listEmployeeEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeEntity> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId){
		EmployeeEntity employee = employeeService.getEmployeeDetailByEmployeeId(myId);
		
		if(employee!=null)
		{
			return new ResponseEntity<EmployeeEntity>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/emp/controller/addEmp",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employee){
		int id= employeeService.addEmployee(employee);
		System.out.println("[id]:"+id);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee){
		EmployeeEntity employee2= employeeService.updateEmployee(employee);
		if(employee2==null){
			return new ResponseEntity<EmployeeEntity>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(employee);
		return new ResponseEntity<EmployeeEntity>(employee2,HttpStatus.OK);
	}
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",
			method=RequestMethod.DELETE,
			//consumes=MediaType.TEXT_PLAIN_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable("id") int myId){
		EmployeeEntity employee= employeeService.deleteEmployee(myId);
		if(employee==null){
			return new ResponseEntity<EmployeeEntity>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Removed: "+employee);
		return new ResponseEntity<EmployeeEntity>(employee,HttpStatus.OK);
	}
}


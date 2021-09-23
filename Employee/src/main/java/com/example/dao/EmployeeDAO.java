package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeEntity;

//Spring jpa
//basic CRud operations are automated
//EmployeeDAOImpl class will be provided at runtime
//SPring DATA JPa is automating
public interface EmployeeDAO  extends JpaRepository<EmployeeEntity, Integer>{

}


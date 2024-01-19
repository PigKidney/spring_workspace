package com.ezen.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public List<EmployeeDTO> getAll(Model model) {
		List<EmployeeDTO> emps = employeeMapper.getAll();
		
		while(emps.size()<10){
			emps.remove((int)(Math.random()*emps.size()));
		}
		
		return emps;
	}
}

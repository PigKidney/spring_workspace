package com.ezen.springrest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.springrest.dto.EmployeeDTO;

public interface EmployeeMapper {
	@Select("SELECT * FROM employees")
	List<EmployeeDTO> getAll();
}

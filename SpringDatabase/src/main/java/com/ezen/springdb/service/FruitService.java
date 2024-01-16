package com.ezen.springdb.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ezen.springdb.dto.FruitDTO;

public interface FruitService {
	int updateForm(Model model, int fruit_id);
	
//	List<FruitDTO> getList();
	void getList(Model model);
	
	int update(FruitDTO dto);
}

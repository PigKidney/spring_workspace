package com.ezen.springrest.service;

import org.springframework.ui.Model;

import com.ezen.springrest.dto.FruitDTO;

public interface FruitService {
	int updateForm(Model model, int fruit_id);
	
	void getFruitList(Model model);
	
//	List<FruitDTO> getList();
	void getList(Model model);
	
	int update(FruitDTO dto);
}

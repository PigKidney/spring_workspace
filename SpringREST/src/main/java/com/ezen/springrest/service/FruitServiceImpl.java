package com.ezen.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springrest.dto.FruitDTO;
import com.ezen.springrest.mapper.CountryMapper;
import com.ezen.springrest.mapper.FruitMapper;


@Service
public class FruitServiceImpl implements FruitService{

	
	@Autowired
	CountryMapper countryMapper;
	
	@Autowired
	FruitMapper fruitMapper;
	
	@Override
	public int updateForm(Model model, int fruit_id) {
		FruitDTO fruit =  fruitMapper.get(fruit_id);
		
		
		if(fruit == null) {
			return -1;
		}
		
		model.addAttribute("fruit",fruit);
		model.addAttribute("countries", countryMapper.getAll());
		
		return 1;
	}
	
//	@Override
//	public List<FruitDTO> getList() {
//		return fruitMapper.getAll();
//	}
	
	@Override
	public void getFruitList(Model model) {
		model.addAttribute("fruits", fruitMapper.getAll());
		model.addAttribute("countries", countryMapper.getAll());

		
	}
	
	@Override
	public void getList(Model model) {
		model.addAttribute("fruits", fruitMapper.getAll());
	}
	
	@Override
	public int update(FruitDTO dto) {
		return fruitMapper.update(dto);
	}
	
}

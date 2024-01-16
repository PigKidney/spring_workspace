package com.ezen.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.mapper.CountryMapper;
import com.ezen.springdb.mapper.FruitMapper;
import com.ezen.springdb.mapper.FruitMapperXML;
import com.ezen.springdb.service.FruitService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class FruitController {
	// @GatMapping, @PostMapping ...등으로 @RequestMapping을 줄여 사용할 수 있다

	
	@Autowired
	FruitService fruitService;
	
	@GetMapping("/fruit/list")
	public void list(Model model) {
		fruitService.getList(model);
//		model.addAttribute("fruits", fruitService.getList());
	}
	
	@GetMapping("/fruit/update")
	public String updateForm(Model model, Integer fruit_id) {
		int result = fruitService.updateForm(model, fruit_id);
		
		if(result == 1) {
			return "/fruit/update";
		} else {
			return "redirect:/fruit/list";
		}
		// 매개변수는 이름만 같이 하면 값을 가져올 수 있다
		//model.addAttribute("fruit", fruitMapper.get(fruit_id));
		//model.addAttribute("countries", countryMapper.getAll());
	}
	
	@PostMapping("/fruit/update")
	public String update(FruitDTO dto) {
		int row = fruitService.update(dto);
		
		if(row == 1) {
			return "redirect:/fruit/list";
		} else {
			return "redirect:/fruit/list";
		}
//		int row =  fruitMapper.update(dto);
//		int row =  fruitMapperXML.updateFruit(dto);

//		return "redirect:/fruit/list";
	}
}

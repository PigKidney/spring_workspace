package com.ezen.board.bulletinBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.board.bulletinBoard.service.MyBoardService;

@Controller
public class MyBoardController{
	
	
	@Autowired
	MyBoardService myBoardService;
	
	@GetMapping("/board/index")
	public void list(Model model) {
		myBoardService.getAllBoard(model);
	}
	
	@GetMapping("/board/writeForm")
	public void write(Model model) {
		myBoardService.getAllBoard(model);
	}
	
	@GetMapping("/board/detail")
	public String detail(Model model, Integer board_id) {
		int result = myBoardService.get(model,board_id);
		
		if(result == 1) {
			return "/board/detail";
		} else {
			return "redirect:/board/index";
		}
	}
	
	@GetMapping("/board/modify")
	public String modify(Model model, Integer board_id) {
		int result = myBoardService.modify(model,board_id);
		if(result == 1) {
			return "/board/modifyForm";
		} else {
			return "redirect:/board/index";
		}
	}
}

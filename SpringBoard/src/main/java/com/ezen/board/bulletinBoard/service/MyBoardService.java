package com.ezen.board.bulletinBoard.service;

import org.springframework.ui.Model;

public interface MyBoardService {
	
	void getAllBoard(Model model);
	
	int write(Model model);
	
	int get(Model model, int board_id); 
	
	int plusView(int board_id);
	
	int modify(Model model, int board_id); 
	
	int delete(int board_id);
}

package com.ezen.board.service;

import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;

public interface BoardService {
	
	void list(Model model);
	
	boolean detail(Model model, int board_id);
	
	//mapper
	int write(BoardDTO dto);
	
	//xml
	int insert(BoardDTO dto);
	
	void replyList(Model model, int board_id);
}

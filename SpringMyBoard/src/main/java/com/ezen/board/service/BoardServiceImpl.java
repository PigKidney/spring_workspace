package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.mapper.BoardMapper;
import com.ezen.board.mapper.BoardMapperXML;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	BoardMapperXML xml;
	
	@Override
	public void list(Model model) {
		model.addAttribute("boards", boardMapper.getAll());
	}
	
	@Override
	public boolean detail(Model model, int board_id) {
//		BoardDTO board = boardMapper.get(board_id);
		BoardDTO board = xml.get(board_id);

		if(board != null) {
			model.addAttribute("board", board);
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public int write(BoardDTO dto) {
	int result = boardMapper.write(dto);
		
		if(result == 1) {
			return dto.getBoard_id();
		} else {
			return result;
		}
	}
	
	
	/**
	 * insert 성공시 테이블 pk반환, 실패시 0을 반환
	 */
	@Override
	public int insert(BoardDTO dto) {
		int result = xml.insert(dto);
		
		if(result == 1) {
			return dto.getBoard_id();
		} else {
			return result;
		}
	
	}
}

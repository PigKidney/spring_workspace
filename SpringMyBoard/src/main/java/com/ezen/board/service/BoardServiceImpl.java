package com.ezen.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.dto.ReplyDTO;
import com.ezen.board.mapper.BoardMapper;
import com.ezen.board.mapper.BoardMapperXML;
import com.ezen.board.mapper.ReplyMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	ReplyMapper replyMapper;
	
	@Autowired
	BoardMapperXML xml;
	
	@Override
	public void list(Model model) {
		List<BoardDTO> dto = boardMapper.getAll();
		model.addAttribute("boards", dto);
		Map<Integer, Integer> repliesCount = new HashMap<>();
		for(BoardDTO board : dto) {
			repliesCount.put(board.getBoard_id(), replyMapper.getRepliesCount((int)board.getBoard_id()));
		}
		model.addAttribute("repliesCount",repliesCount);
		
		List<ReplyDTO> replyDto = replyMapper.getAllReplies();
		model.addAttribute("replies",replyDto);
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
	
	@Override
	public void replyList(Model model, int board_id) {
		List<ReplyDTO> dto = replyMapper.getBoardReplies(board_id);
		model.addAttribute("replies", dto);
	}
}

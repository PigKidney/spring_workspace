package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.BoardDTO;

public interface BoardMapperXML {
	BoardDTO get(int board_id);
	
	int insert(BoardDTO dto);
	
	List<BoardDTO> getAllWithReplyCount();
}

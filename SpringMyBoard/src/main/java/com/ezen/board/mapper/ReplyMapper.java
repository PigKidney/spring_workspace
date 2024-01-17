package com.ezen.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.board.dto.ReplyDTO;

public interface ReplyMapper {
	
	@Select("SELECT * FROM myreply WHERE board_id=#{board_id}")
	List<ReplyDTO> getBoardReplies(int board_id);
	
	@Select("SELECT * FROM myreply")
	List<ReplyDTO> getAllReplies();
	
	@Select("SELECT COUNT(*) FROM myreply WHERE board_id = #{board_id} GROUP BY board_id")
	Integer getRepliesCount(int board_id);
}

package com.ezen.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ezen.board.dto.BoardDTO;


public interface BoardMapper {
	@Select("SELECT * FROM myboard ORDER BY board_id DESC")
	List<BoardDTO> getAll();
	
	@Insert("INSERT INTO myboard(board_id,board_title,board_content,board_password,board_writer) VALUES(myboard_id_seq.nextval, #{board_title}, #{board_content},#{board_password},#{board_writer})")
	int write(BoardDTO dto);
	
	@Select("SELECT * FROM myboard WHERE board_id=#{id}")
	BoardDTO get(@Param("id") int board_id);
	
	@Update("UPDATE myboard SET view_count=view_count+1 WHERE board_id=#{id}")
	int plusView(@Param("id") int board_id);
	
	@Update("UPDATE myboard SET board_title=#{board_title},board_content=#{board_content} WHERE board_id=#{board_id}")
	int modify(BoardDTO dto);
	
	@Delete("DELETE FROM myboard WHERE board_id=#{id}")
	int delete(@Param("id")int board_id);
}

package com.ezen.board.bulletinBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.bulletinBoard.dto.MyBoardDTO;
import com.ezen.board.bulletinBoard.mapper.MyboardMapper;


@Service
public class BulletinBoardServiceImpl implements MyBoardService{
	
	@Autowired
	MyboardMapper myboardMapper;

	@Override
	public void getAllBoard(Model model) {
		model.addAttribute("boards",myboardMapper.getAll());
		
	}

	@Override
	public int write(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get(Model model, int board_id) {
		MyBoardDTO dto = myboardMapper.get(board_id);
		
		if(dto == null) {
			return -1;
		}
		model.addAttribute("detail", myboardMapper.get(board_id));
		
		return 1;
	}

	@Override
	public int plusView(int board_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Model model, int board_id) {
		MyBoardDTO dto = myboardMapper.get(board_id);
		
		if(dto == null) {
			return -1;
		}
		model.addAttribute("oldData", myboardMapper.modify(myboardMapper.get(board_id)));
		
		return 1;
	}

	@Override
	public int delete(int board_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}

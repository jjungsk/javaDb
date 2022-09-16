package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.BoardDto;

public interface BoardDao {
	
	List<BoardDto> listArticle() throws Exception;

}

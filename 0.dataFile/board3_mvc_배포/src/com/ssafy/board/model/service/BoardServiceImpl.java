package com.ssafy.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {}

	public static BoardService getBoardService() {
		return boardService;
	}

	@Override
	public int registerArticle(BoardDto boardDto) throws Exception {
		return 0;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		return null;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws Exception {

	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {

	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {

	}

}

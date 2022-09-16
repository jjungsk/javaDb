package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {}

	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	@Override
	public int registerArticle(BoardDto boardDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalArticleCount(Map<String, String> map) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub

	}

}

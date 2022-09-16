package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private BoardDao boardDao;
	
	public void init() {
		boardDao = BoardDaoImpl.getBoardDao();
	}
	

	// 보기, 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act"); // parameter 얻어옴
		
		String path = "/index.jsp";
		if ("list".equals(act)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("mvwrite".equals("act")) {
			
		} else if ("".equals("act")) {
			
		} else if ("".equals("act")) {
			
		} else if ("".equals("act")) {
			
		}

		
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}


	private String list(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			List<BoardDto> list = boardDao.listArticle();
			request.setAttribute("articles", list);
			return "/board/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "글목록 처리중 에러 발생");
			return "/error/error.jsp";
		}
		
	}

	// 쓰기, 읽기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
		
	}

}

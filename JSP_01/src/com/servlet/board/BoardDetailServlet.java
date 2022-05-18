package com.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dataSource.DataSource;
import com.jsp.vo.Board;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	
	private DataSource dataSource = DataSource.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource datasource = DataSource.getInstance();
		
		String url="/WEB-INF/views/board/detail.jsp";
		
		String bno = request.getParameter("bno");
		int ViewCnt = datasource.getBoardList().get(bno).getViewCnt();
		
		//Member member = memberService.detail(id);
		Board board = dataSource.getBoardList().get(bno);
		board.setViewCnt(++ViewCnt);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

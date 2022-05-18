package com.servlet.board;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dataSource.DataSource;
import com.jsp.vo.Board;

@WebServlet("/board/modify")
public class BoardModifyServlet extends HttpServlet {
	private DataSource dataSource = DataSource.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/board/modify.jsp";
		
		String bno = request.getParameter("bno");
		
		// Member member = memberService.detail(id);
		Board board = dataSource.getBoardList().get(bno);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		String url = request.getContextPath()+"/board/detail?bno="+bno;
				
		//처리
		Board board = dataSource.getBoardList().get(bno);
		
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setRegDate(new Date());
		
		//memberService.regist(member); <-----DB저장
			
		dataSource.getBoardList().put(bno, board);
				
		System.out.println(board);
				
		//출력
		response.sendRedirect(url);		
	}

}

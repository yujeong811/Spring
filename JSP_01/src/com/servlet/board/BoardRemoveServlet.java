package com.servlet.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dataSource.DataSource;

@WebServlet("/board/remove")
public class BoardRemoveServlet extends HttpServlet {
	private DataSource dataSource = DataSource.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect 사용 시 getContextPath()가 없으면 안돼
		String url = request.getContextPath() + "/board/list";
		String bno = request.getParameter("bno");
		
		dataSource.getBoardList().remove(bno);
		
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

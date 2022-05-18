package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/common/login.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 입력(id/pwd)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String message = "";
		
		if (id != null && id.equals("mimi")) {
			if(pwd != null && pwd.equals("mimi")) {
				message = "로그인을 성공하였습니다.";
			} else {
				message = "비밀번호가 일치하지 않습니다.";
			}
		} else {
			message = "아이디가 존재하지 않습니다.";
		}
		
		// 로그인 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}

}

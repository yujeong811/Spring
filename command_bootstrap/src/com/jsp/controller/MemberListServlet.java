package com.jsp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/list.jsp";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		
		Criteria cri = new Criteria();
		
		boolean criFlag = true;
		criFlag = criFlag && pageParam != null
						  && !pageParam.isEmpty()
						  && perPageNumParam != null
						  && !perPageNumParam.isEmpty();
		
		if(criFlag) {
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));			
			} catch(Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return;
			}
		}
		
		try {
//			List<MemberVO> memberList = memberService.getMemberList(cri);
//			request.setAttribute("memberList", memberList);
			Map<String,Object> dataMap = memberService.getMemberListForPage(cri);
			request.setAttribute("dataMap", dataMap);
			
		} catch (Exception e) {
			url = "/WEB-INF/views/error/500.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

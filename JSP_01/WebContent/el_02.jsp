<%@page import="com.jsp.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%
	Member member = new Member();
	member.setId("mimi");
	member.setPwd("mimi"); 
	//Object id = request.getAttribute("id");
	//request.setAttribute("member", member);
	pageContext.setAttribute("member", member);
%>  --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디 : ${member.id }</h1>
	<h1>패스워드 : ${member.pwd }</h1>
</body>
</html>
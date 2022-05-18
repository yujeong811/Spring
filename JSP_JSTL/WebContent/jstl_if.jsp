<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="a" value="10" />

<%
	int a = 10;
	if (a > 10) {
		out.println("a는 10보다 큽니다.");
	}
%>
<hr/>

<c:set var="a" value="11" />
<c:if test="${a eq 10}">
	a는 10보다 큽니다.
</c:if>
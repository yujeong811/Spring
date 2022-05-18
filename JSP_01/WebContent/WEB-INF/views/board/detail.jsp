<%@page import="java.util.List"%>
<%@page import="com.jsp.vo.Board"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
h1 {
text-align : center;
}

tr {
text-align : center;
}

button {
	float : right;
	margin-right : 10px;
}

#one {
	margin-right : 300px;
}

</style>
</head>
<body>
	<h1>게시글상세</h1>
		<button type="button" id="one" class="btn btn-dark" onclick="location.href='<%=request.getContextPath()%>/board/modify?bno=${board.bno }';" >수정</button>&nbsp;&nbsp;&nbsp;
		<button type="button"  class="btn btn-dark" onclick="location.href='<%=request.getContextPath()%>/board/remove?bno=${board.bno }';">삭제</button>&nbsp;&nbsp;&nbsp;
		<button type="button"  class="btn btn-dark" onclick="location.href='list';">목록</button>
	<hr/>
	<div class="container">
	<table class="table table-striped">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
 	</thead>
 	<tbody>
		<tr>
			<td>${board.bno }</td>
			<td>${board.title }</td>
			<td>${board.writer }</td>
			<td>${board.content }</td>
			<td>${board.regDate }</td>
			
			<td>${board.viewCnt }</td>
		</tr>
		</tbody>
	</table>
	</div>
</body>
</html>
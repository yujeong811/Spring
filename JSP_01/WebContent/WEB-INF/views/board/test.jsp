<%@page import="com.jsp.command.PageMaker"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.jsp.vo.Board"%>
<%@page import="java.util.List"%>

<%
	Map<String, Object> dataMap = (Map<String, Object>) request.getAttribute("dataMap");
	List<Board> boardList = (List<Board>) dataMap.get("boardList");
	PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<style type="text/css">
h2 {
	text-align: center;
}

tr {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h2>게시판리스트</h2>
		<div id="keyword" class="card-tools" style="width:550px;">
   					 <div class="input-group row">
   					 	<!-- search bar -->
   					 	<!-- sort num -->
					  	<select class="form-control col-md-3" name="perPageNum" 
					  			id="perPageNum" onchange="">					  		  		
					  		<option value="10" >정렬개수</option>
					  		<option value="2" >2개씩</option>
					  		<option value="3">3개씩</option>
					  		<option value="5" >5개씩</option>
					  	</select>
					  	
					  	
   					 </div>
   				</div>  
		<button onclick="location.href='regist';" class="btn btn-dark"
			type="button" style="display: block; float: right;">글쓰기</button>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<%
				//List<Board> boardList = (List<Board>) request.getAttribute("boardList");
				//out.print(memberList);
				//int count = 0;
				if (boardList != null)
					for (Board board : boardList) {
						SimpleDateFormat mimi = new SimpleDateFormat("yyyy-MM-dd");
						pageContext.setAttribute("board", board);
						//pageContext.setAttribute("bno",count++);
			%>
			<tr style="text-align: center; cursor: pointer;"
				onclick="location.href='detail?bno=${board.bno}';";>
				<td>${board.bno }</td>
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td><%=mimi.format(board.getRegDate())%></td>
			</tr>
			<%
				}
				else {
			%>
			<tr>
				<td colspan="4">해당내용이 없습니다.</td>

			</tr>
			<%
				}
			%>
		</table>
	</div>
	<div class="card-footer">
		<!-- pagination -->
		<nav aria-label="Navigation">
			<ul class="pagination justify-content-center m-0">
				<li class="page-item"><a class="page-link"
					href="javascript:list_go(1);"> <i
						class="fas fa-angle-double-left"></i>
				</a>
				<li class="page-item"><a class="page-link" href=""> <i
						class="fas fa-angle-left"></i>
				</a></li>

				<%
					int startPage = pageMaker.getStartPage();
					int endPage = pageMaker.getEndPage();
					int pageNum = pageMaker.getCri().getPage();

					for (int i = startPage; i < endPage + 1; i++) {
				%>
				<li class="page-item  <%=(i == pageNum) ? "active" : ""%>"><a
					class="page-link" href="javascript:list_go(<%=i%>);"><%=i%></a></li>
					

				<%
					}
				%>

				<li class="page-item"><a class="page-link" href=""> <i
						class="fas fa-angle-right"></i>
				</a></li>
				<li class="page-item"><a class="page-link" href=""> <i
						class="fas fa-angle-double-right"></i>
				</a></li>
			</ul>
		</nav>
	</div>
	<form id="jobForm">
		<input type='hidden' name="page" value="" />
		<input type='hidden' name="perPageNum" value="" />
		<input type='hidden' name="searchType" value="" />
		<input type='hidden' name="keyword" value="" />
	</form>

	<script>
		function list_go(page, url) {
			//alert(page);
			if (!url)
				url = "list";

			var jobForm = $('#jobForm');
			jobForm.find("[name='page']").val(page);
			jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());

			jobForm.attr({
				action : url,
				method : 'get'
			}).submit();

		}
	</script>
</body>
</html>

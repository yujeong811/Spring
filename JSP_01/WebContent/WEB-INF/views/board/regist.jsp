<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
text-align : center;
}

</style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>게시글 작성</h1>
	<div class="container">
	<form action="regist" method="post" >
  <div class="form-group">
    <label for="title">제목 : </label>
    <input type="text" class="form-control" placeholder="Enter title" name="title">
  </div>
  <div class="form-group">
    <label for="writer">작성자 : </label>
    <input type="text" class="form-control" placeholder="Enter writer" name="writer">
  </div>
   <div class="form-group">
    <label for="content">내용 : </label><br>
    <textarea rows="10" cols="150" name="content" placeholder="Enter content"></textarea>
  </div>
  <button type="submit" class="btn btn-primary">등록</button>
</form>
</div>
</body>
</html>
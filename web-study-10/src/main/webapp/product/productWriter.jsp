<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>상품 등록(관리자 페이지)</h2>

		<form action="productWrite.do" method="post" enctype="multipart/form-data" name="frm">
			<div class="form-group">
				<label for="name">상품명 :</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="price">가격 :</label> <input type="text"
					class="form-control" id="price" name="price">
			</div>
			<div class="form-group">
				<label for="pictureurl">사진 :</label> 
				<input type="file" id="pictureurl" name="pictureurl">
					<br>(주의사항 : 이미지를 변경하고자 할 때만 선택)
			</div>
			<div class="form-group">
				<label for="discription">설명 :</label>
				<textarea rows="10" cols="80" name="description"></textarea> 
			</div>

			<button type="submit" class="btn btn-warning">등록</button>&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-info">다시작성</button>&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-dark" onclick="location.href='productList.do'">목록</button>
		</form>

	</div>
</body>
</html>
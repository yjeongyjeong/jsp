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

<!-- product : ${product}  -->
<!-- servlet에서 setAttribute로 product라는 이름에 vo를 담았음으로 vo가 출력되어야 함! -->


	<div class="container">
		<h2>상품 삭제(관리자 페이지)</h2>
<hr>
		<form action="productDelete.do" method="post"  name="frm">
		<input type="hidden" name="code" value="${product.code}">
		<!-- 히든한이유 ? primary key (code) 닉간...? 맞음! 이걸로 값을 넘겨줘야하는데 굳이 노출될 필요 없으니까
		여기 있는 애들은 product.~~~하는것들은 vo객체에서 가져온거니까 이름이 거기서 일치해야함-->
		
		
		<c:choose>
			<c:when test="${empty product.pictureurl}">
				<img src="upload/noimage.gif" width="300px" height="200px">
			</c:when>		
			<c:otherwise>
				<img src="upload/${product.pictureurl}" width="300px" height="200px">
			</c:otherwise>
		</c:choose>
		<br><hr><br>
			<div class="form-group">
				<label for="name">상품명 :</label> <input type="text"
					class="form-control" id="name" name="name" value="${product.name}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="price">가격 :</label> <input type="text"
					class="form-control" id="price" name="price" value="${product.price}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="discription">설명 :</label>
				<textarea rows="10" cols="80" name="description" readonly="readonly">${product.description}</textarea> 
			</div>

			<button type="submit" class="btn btn-warning" onclick="location.href='productList.do'">삭제</button>&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-dark" onclick="location.href='productList.do'">목록</button>
		</form>

	</div>
</body>
</html>
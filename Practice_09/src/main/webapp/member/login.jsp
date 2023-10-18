<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%@ include file="loginHeader.jsp"%>
<!-- 
th : header in a table
tr : row in a table
td : cell in a table
 -->
	<form action="login.do" method="post">
		

			<label for="id">아이디</label> 
			<input type="text" name="id" id="id"> <br>
			<label for="pwd">비밀번호</label> 
			<input type="password" name="pwd" id="pwd"><br>
- 			<label for="lev">레벨</label>
      		<select class="form-control" id="lev" name="lev"><br>
        	<option value="0">일반회원</option>
	        <option value="1">관리자</option>
    		</select>		 
			
 			<input type="submit" value="로그인"> 
			<input type="reset" value="취소">

	</form>
</body>
</html>
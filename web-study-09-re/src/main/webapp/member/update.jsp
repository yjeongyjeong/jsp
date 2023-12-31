<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./script/member.js"></script>
<!-- . -> 이 폴더 빠져나가서 /들어가라고 -->

<title>Insert title here</title>
</head>
<body>
	<h2>회원정보수정</h2>
	<form action="memberUpdate.do" method="post" name="frm"><!-- 서블릿으로 보냄 폼태그?컨텍스트패스?쿼리스트링?은 login.do가 되고 서블릿에서 post로 받도록 함 name도 지정함(js)에서 사용-->

		<div class="form-group">
			<label for="name">User name :</label> <input type="text"
				class="form-control" id="name" placeholder="Enter name"
				name="name" value="${mVO.name}">
		</div>
		<div class="form-group"> 
			<label for="userid">User Id :</label> 
			<input type="text"
				class="form-control" id="userid" placeholder="${mVO.userid}"
				name="userid" readonly="readonly" value="${mVO.userid}">
				<!-- loginUser로도 받을 수 있는데 왜 mVO를 하는 걸까? request.setAttribute("mVO", vo); //mVO라는 이름에 vo값을 넣어줌 참조변수해줬어서 vo를 mVO로 이미 받아버림-->			
		</div>
		<div class="form-group">
			<label for="pwd">Password : </label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="pwd">
		</div>
		<div class="form-group">
			<label for="pwd_check">Password check: </label> 
			<input type="password"
				class="form-control" id="pwd_check" placeholder="Enter password"
				name="pwd_check">
		</div>
		
		<div class="form-group">
			<label for="email">User email :</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email" value="${mVO.email}">
		</div>
		<div class="form-group">
			<label for="phone">User phone :</label> <input type="text"
				class="form-control" id="phone" placeholder="Enter phone"
				name="phone" value="${mVO.phone}">
		</div>
		<div class="checkbox">
			<label><input type="checkbox" name="remember">
				Remember me</label>
		</div>
		
		<c:if test="${mVO.admin == 0}">
		
		<div class="form-group">	
		<label for="admin">등급</label><br>	
		<input type="radio" name="admin" value="0" checked="checked">일반회원
		<input type="radio" name="admin" value="1" >관리자
		</div>
		</c:if>
		<c:if test="${mVO.admin == 1}">
		
		<div class="form-group">	
		<label for="admin">등급</label><br>	
		<input type="radio" name="admin" value="0" >일반회원
		<input type="radio" name="admin" value="1" checked="checked">관리자
		</div>
		</c:if>
		
		<button type="submit" class="btn btn-primary">수정</button> 
		<button type="reset" class="btn btn-success">취소</button>
		<hr>
		<h4 style="color: red;">${message}</h4> 



	</form>

</body>
</html>
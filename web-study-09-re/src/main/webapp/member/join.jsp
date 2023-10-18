<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h2>회원가입</h2>
	<form action="join.do" method="post" name="frm"><!-- 서블릿으로 보냄 폼태그?컨텍스트패스?쿼리스트링?은 login.do가 되고 서블릿에서 post로 받도록 함 name도 지정함(js)에서 사용-->

		<div class="form-group">
			<label for="name">User name :</label> <input type="text"
				class="form-control" id="name" placeholder="Enter name"
				name="name">
		</div>
		<div class="form-group"> 
			<label for="userid">User Id :</label>
			<input type="button" value="중복체크" class="btn btn-info btn-sm float-right" onclick="idCheck()"> 
			<input type="text"
				class="form-control" id="userid" placeholder="Enter Id"
				name="userid">
			<input type="hidden" name="reid"> <!-- 화면에는 보이지 않지만 값이 전송됨 
=> 나는 그냥 값을 저장시켜놓으려고.. 하는줄알았는데(저장된 값 바꾸려면 변수 더 필요하니까) 
=> 아이디 중복체크 과정을 거쳣는디 확인하기 위해서 만든 변수였음!!!-->
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
				name="email">
		</div>
		<div class="form-group">
			<label for="phone">User phone :</label> <input type="text"
				class="form-control" id="phone" placeholder="Enter phone"
				name="phone">
		</div>
		<div class="checkbox">
			<label><input type="checkbox" name="remember">
				Remember me</label>
		</div>
		
		<div class="form-group">	
		<label for="admin">등급</label><br>	
		<input type="radio" name="admin" value="0" checked="checked">일반회원
		<input type="radio" name="admin" value="1" >관리자
		</div>
		
		<hr>
		<button type="submit" class="btn btn-primary">확인</button> 
		<button type="reset" class="btn btn-success">취소</button>




	</form>

</body>
</html>
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
	<h1>로그인</h1>
	<form action="login.do" method="post" name="frm"><!-- 서블릿으로 보냄 폼태그?컨텍스트패스?쿼리스트링?은 login.do가 되고 서블릿에서 post로 받도록 함 name도 지정함(js)에서 사용-->
		<div class="form-group">
			<label for="userid">User Id :</label> <input type="text"
				class="form-control" id="userid" placeholder="Enter Id"
				name="userid">
		</div>
		<div class="form-group">
			<label for="pwd">Password : </label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="pwd">
		</div>
		<div class="checkbox">
			<label><input type="checkbox" name="remember">
				Remember me</label>
		</div>
		<button type="submit" class="btn btn-primary" onclick="return loginCheck()">로그인</button> <!-- 클릭 시 loginCheck()라는 js파일이 실행되도록 함 : 로그인 함수?메서드? 
		type = submit 누르면 위에 폼태그로 감!!-->
		<button type="reset" class="btn btn-success">취소</button>
		<button type="button" class="btn btn-info" onclick="location.href='join.do'">회원가입</button><!-- 클릭 시 join.do(joinservlet의 doGet) 로 가도록 함 -->
		<hr>
		<h4 style="color: red;">${message}</h4> 



	</form>

</body>
</html>
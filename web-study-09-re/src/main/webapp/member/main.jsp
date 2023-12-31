
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
	<h1>회원 전용 페이지</h1>
	<form action="logout.do">

		안녕하세요 ${loginUser.name}(${loginUser.userid}) 님
		<!-- session.setAttribute("loginUser", vo); //loginUser는 섹션이라 브라우저 끄기 전까지 값이 기억됨, vo로 값을 받아와서 전부 출력됨(toString한대로..)
결과는 이렇게 출력됨 MemberVO(name=이소미, userid=somi, pwd=1234, email=somi@naver.com, phone=010-111-2222 , admin=0)
 -->
		<br><br>
		<!-- 이동할 떄 바로가지 않고 서블릿 통해서 가기 -->
		<button type="submit" class="btn btn-success">로그아웃</button>
		<button type="button" class="btn btn-info"
			onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">회원정보변경</button>
		<!-- 클릭 시 'memberUpdate.do?userid=${loginUser.userid}'로 가도록 함(get방식) -->

	</form>

</body>
</html>
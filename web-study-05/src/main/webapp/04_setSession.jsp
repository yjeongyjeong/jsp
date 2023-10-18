<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		session.setAttribute("id", "test");
		session.setAttribute("pwd", "test1234");
		session.setAttribute("age", 20);
		//"20"으로 받는 경우에는 String으로 받고 Integer.parseInt해주면 됨
	%>
<h2>세션 설정</h2>

</body>
</html>
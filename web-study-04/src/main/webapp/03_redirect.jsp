<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로드북 페이지로 이동</h1>
	<%= request.getParameter("name") %>
	<%= request.getParameter("age") %>
	<!-- http://localhost:8181/web-study-04/03_redirect.jsp?name=kim&age=20 이렇게 주소를 줘도 페이지에 처리됨 -->
	<%
		//response.sendRedirect("http://www.naver.com");
	// http://localhost:8181/web-study-03/03_redirect.jsp 로 가도 네이버로 가게됨
	%>
</body>
</html>
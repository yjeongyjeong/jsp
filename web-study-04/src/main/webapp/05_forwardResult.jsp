<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String age = request.getParameter("age");
	//String name = request.getParameter("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h1>forward 방식으로 이동된 페이지</h1><br>
나이 : <%= age %>
이름 : <%= request.getAttribute("name") %><br> 
이름 : ${name } 
<!-- 이름은 넘겨받음(객체에 저장?)
포워드의 경우 객체가 사라지지 않기 때문에 같은 객체를 다른데서도 참조할 수 있음 -->
</body>
</html>
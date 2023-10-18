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
		String id = (String)(session.getAttribute("id"));
		String pwd = (String)session.getAttribute("pwd");
		Integer age1 = (Integer)session.getAttribute("age");
		//Integer age = Integer.parseInt((String)session.getAttribute("age"));
	%>
	<h1>session 조회</h1>
	<%=id %>
	<%=pwd %>
	<%=age1 %>
	<%-- <%=age %> --%>
</body>
</html>
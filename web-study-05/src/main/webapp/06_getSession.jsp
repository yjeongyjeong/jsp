<%@page import="java.util.Enumeration"%>
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
	Enumeration names = session.getAttributeNames();

	while (names.hasMoreElements()) {
		String name = names.nextElement().toString(); //키
		String value = session.getAttribute(name).toString(); //value
		out.println(name + " " + value + "<br>");
	}

	/* 04_setSession에서 설정한 session값이 출력됨
	id test
	pwd test1234
	age 20
	05_remove하고 다시 06get하면 invalidate 되었기 때문에 값출력안됨
	*/
	%>

</body>
</html>
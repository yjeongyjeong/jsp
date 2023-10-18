<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>고전적인 방식</h2>
아이디 : <%=request.getParameter("id") %>
비밀번호 : <%=request.getParameter("pwd") %>
<!-- id와 pwd는 속성명의 값 -->
<h2>el 방식</h2>
아이디 : ${param.id }
비밀번호 : ${param["pwd"] }
비밀번호 : ${param.pwd }
<br>
param : ${param }
</body>
</html>
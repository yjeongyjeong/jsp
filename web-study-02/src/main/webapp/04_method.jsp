<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
	<form action="method" method="get">
		<input type="text" name=id>
		<input type="text" name="age">
	
		<input type="submit" value="get 방식으로 호출하기">
		<!-- http://localhost:8181/web-study-02/method?id=park&age=20 -->
	</form>
	</h1>
	
	<form action="method" method="post">
		<input type="submit" value="post 방식으로 호출하기">
		<!-- http://localhost:8181/web-study-02/method -->
	</form>
</body>
</html>
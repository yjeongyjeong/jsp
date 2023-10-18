<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />
	<hr>
	<h1>자바빈 객체 생성 후 저장된 정보 출력</h1>
	이름 : <jsp:getProperty property="name" name="member"/><br>
	아이디 : <jsp:getProperty property="userid" name="member"/><br>
	
	<h1>정보 변경 후 저장된 정보 출력</h1>
	<jsp:setProperty property="name" name="member" value="조조"/>
	<jsp:setProperty property="userid" name="member" value="test02"/>
	
	이름 : <jsp:getProperty property="name" name="member"/><br>
	아이디 : <jsp:getProperty property="userid" name="member"/><br>
</body>
</html>
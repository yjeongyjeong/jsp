
<%@page import="com.saeyan.dao.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>DB 연동</h3>

	<% //memberdao에 생성 메서드를 넣어두고 객체 생성해서 생성 메서드를 실행시킴 -> 결과확인
		MemberDAO memDao = MemberDAO.getinstance();
		Connection con = memDao.getConnection();
		out.println("con : " + con + "<br>");
		out.println("DBCP 연동 성공");
	%>
</body>
</html>
<%@page import="com.saeyan.dao.MemberDAO"%>
<%@page import="com.saeyan.dto.MemberVO"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
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
	MemberDAO mDao = MemberDAO.getInstance();
	Connection conn = mDao.getConnection();
	
	System.out.println("conn : " + conn);
	%>
</body>
</html>
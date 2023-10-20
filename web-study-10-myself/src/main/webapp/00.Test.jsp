<%@page import="java.sql.Connection"%>
<%@page import="com.myself.member.dao.MemberDAO"%>
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
out.print("conn : " + conn);
%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = "http://localhost:8181/HRD-myself/MemberServlet?command=member_join";
	response.sendRedirect(url);
%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String id = "test";
		String pwd = "1234";
		String name2 = "조조";
		
		request.setCharacterEncoding("utf-8");
		
		if(id.equals(request.getParameter("id"))){
			if(pwd.equals(request.getParameter("pwd"))){
				//response.sendRedirect("04_main.jsp?name=" + id);
				//response.sendRedirect("04_main.jsp?name=" + name2); 한글에러남
				response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(name2, "utf-8"));
				//urlencoder로 한글작업해줘야 안깨짐
			}
		} else {
			response.sendRedirect("04_loginForm.jsp");
		}
	%>
    
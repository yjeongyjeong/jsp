<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${emp.lev =='C'}">
		<p align="center"> 당신은 권한이 없습니다.
	</c:if>
	<c:if test="${empty emp}">
		<p align="center"> 로그인 하시면 더 좋은 정보를 얻을 수 있습니다.
	</c:if>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 페이지 내용이 저장됨 -->
	<c:import url="http://localhost:8181/web-study-07/10_jstl.jsp" var="data">
	</c:import>
	${data }

</body>
</html>
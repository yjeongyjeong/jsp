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
	<%
	String[] movieList = { "타이타닉", "시네마 천국", "혹성 탈출", "킹콩" };
	request.setAttribute("movieList", movieList);
	//movieList라는 이름(키값같은느낌)에다가 뒤에 배열을 하나씩 넣어준다는 의미
	%>
	
	<c:forEach var="movie" items="${movieList}">
		${movie } <br>
	</c:forEach>
	<!-- movie라는 변수로 movieList라는 배열을 돌리겠다는 의미 그리고 ${movie}로 프린트 -->
	<hr>
	
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		${status.index } &nbsp;&nbsp; <!-- 0부터시작 -->
		${status.count } &nbsp;&nbsp; <!-- 1부터시작 -->
		${movie } <br>
	</c:forEach>
	<hr>
	
<%-- 	<c:forEach var="movie" items="${movieList}" varStatus="status">
		${status.first }<br>
		${status.last }<br>
	</c:forEach> --%>
	
	<!-- 시작이랑 마지막 데이터 찍어주기 -->
		<c:forEach var="movie" items="${movieList}" varStatus="status">
		<c:if test="${status.first}">
			${movie }<br>
		</c:if>
		<c:if test="${status.last}">
			${movie }
		</c:if>
	</c:forEach>
	
	
</body>
</html>
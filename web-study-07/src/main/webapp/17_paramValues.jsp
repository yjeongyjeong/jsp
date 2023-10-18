<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신이 선택한 장르<hr>
	<c:forEach var="item" items="${paramValues.item }" varStatus="status">
		${item} <c:if test="${not status.last }">, </c:if>
	</c:forEach>

<!-- paramValues : 지정한 이름을 가진 파라미터의 모든 값을 배열 형태러 얻어옴 
	 status.last : 현재 루프가 마지막인지 반환 => 마지막이 아니면 , 가 찍히도록 함
-->
</body>
</html>

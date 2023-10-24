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
<body>
	<div id="wrap" align="center">
		<h1>회원 매출 조회</h1>	
		<%-- 나오나 테스트해봄 ${memberList} --%>
		<table class="list" border="1">

			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>

			<tr>
				<c:forEach items="${memberList}" var="member">
					<tr class="record">
						<td>${member.custno}</td>
						<!-- num이 pk라서 같이 가야함 -->
						<td>${member.custname}</td>
						<td>
						<c:if test="${member.grade eq 'A'}">
							VIP
						</c:if>
						<c:if test="${member.grade eq 'B'}">
							일반
						</c:if>
						<c:if test="${member.grade eq 'C'}">
							직원
						</c:if>
						</td>
						<td>${member.price}</td>
					</tr>
				</c:forEach>
		</table>

	</div>
</body>


</html>
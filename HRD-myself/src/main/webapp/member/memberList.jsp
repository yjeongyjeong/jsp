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
	<div id="wrap" align="center">
		<h1>회원목록 조회/수정</h1>
		<table class="list" border="1">

			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
			<tr>
				<c:forEach items="${memberList}" var="member">
					<tr class="record">
						<td><a
							href="MemberServlet?command=member_update_form&custno=${member.custno}">${member.custno}</a></td>
						<!-- num이 pk라서 같이 가야함 -->
						<td>${member.custname}</td>
						<td>${member.phone}</td>
						<td>${member.address}</td>
						<td>${member.joindate}</td>
						<td>${member.grade}</td>
						<td>${member.city}</td>
					</tr>
				</c:forEach>
		</table>

	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/function.js"></script>
</head>
<body>
<%@ include file="/insertPage/header.jsp" %>
	<%-- 테스트 ${boardList}<br> --%>

	<div id="wrap" align="center">
		<h1>홈쇼핑 회원 정보 수정</h1>
		<form name="frm" method="post" action="MemberServlet">
			<!-- post방식이라 command값을 쿼리스트링으로 보낼 수 없음 따라서 아래처럼 히든으로 값을 넘겨줌!!! 대박새롭-->
			<input type="hidden" name="command" value="member_update">
			<input type="hidden" name="custno" value="${member.custno}">
			<table border="1">
				<tr>
					<th>회원번호(자동발행)</th>
					<td><input type="text" name="custno" readonly="readonly" value="${member.custno}"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value="${member.custname}"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" value="${member.phone}"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" value="${member.address}"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" value="${member.joindate}" readonly="readonly"> </td>
				</tr>
				<tr>
					<th>고객등급</th>
					<td><input type="text" name="grade" value="${member.grade}"> </td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value="${member.city}"> </td>
				</tr>
			</table>
			<br>

			<br> 
			<input type="submit" value="수정" onclick="return updateCheckOkay()"> 
			<input type="button" value="조회" onclick="location.href='MemberServlet?command=member_list'">
		</form>
	</div>
<%@ include file="/insertPage/footer.jsp" %>
</body>
</html>
</body>
</html>
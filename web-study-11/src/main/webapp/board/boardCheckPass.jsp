<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<%-- 테스트 ${boardList}<br> --%>

	<div align="center">
		<h1 align="left">비밀번호 확인</h1>
		<form action="BoardServlet" name="frm" method="get">
		<!-- ${board.num}가 먹지 않음 왜일까? 포워드로 넘겨받았는데 왜일까? 
		클라이언트에서 바로 날아온거라 board자체가 없나봄?
		setattribute는 담은거고....
		-->
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="num" value="${param.num}">
			
			<table style="width : 80%">
				<tr>비밀번호</tr>
				<td><input type="password" name="pass" size="20"></td>
			</table>
			<br>
			<input type="submit" value="확인" onclick="return passCheck()">
			
		<br><br>${message}${num}
		</form>
		
	</div>
</body>
</html>
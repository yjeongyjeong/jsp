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

	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border:red; text-align:right;">
					<a href="BoardServlet?command=board_write-form">게시글 등록</a>
				</td>
			</tr>
			
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			<tr>
			<c:forEach items="${boardList}" var="board">
				<tr class="record">
					<td>${board.num}</td>
					<td><a href="BoardServlet?command=board_view&num=${board.num}">${board.title}</a></td>
					<!-- num이 pk라서 같이 가야함 -->
					<td>${board.name}</td>
					<td>${board.writedate}</td>
					<td>${board.readcount}</td>
				</tr>
			</c:forEach>
		</table>				
		
	</div>
</body>
</html>
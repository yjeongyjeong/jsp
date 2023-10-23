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
		<h1>게시글 상세보기</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td>${board.name}</td>
			<th>이메일</th>
			<td>${board.email}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.writedate}</td>
			<th>조회수</th>
			<td>${board.readcount}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${board.content}</td>
		</tr>

		</table>
		<br>
		<hr>
		<br> 
		<input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'update')"> 
		<input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'delete')"> 
		<input type="button" value="게시글 리스트" onclick="location.href='BoardServlet?command=board_list' "> 
		<input type="button" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write-form' "> 
		
<!-- board.js에서 function open_win(url, name){
    window.open(url, name, "width=500, height=230");로 인해 url과 name을 매개변수로 받는 새창이 열리게됨
} -->
	</div>
</body>
</html>
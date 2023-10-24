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
		<h1>이건 헤더</h1>
		<table class="list" border="1">
			
				<th><a href="MemberServlet?command=member_join_form">회원등록</a></th>
				<th><a href="MemberServlet?command=member_list">회원목록조회/수정</a></th>
				<th><a href="MemberServlet?command=member_total">회원매출조회</a></th>
				<th ><a href="MemberServlet?command=member_join">홈으로.</a></th>
			</table>
			</div>
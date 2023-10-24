<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<h2>홈쇼핑 회원 등록</h2>
<table>
	<colgroup>
		<col width="10%">
		<col width="10%">
		<col width="20%">
		<col width="20%">
		<col width="20%">
		<col width="10%">
		<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${lists}">
			<tr style="text-align:center;">
				<td>${list.custNo}</td>
				<td>${list.custName}</td>
				<td>${list.phone}</td>
				<td>${list.address}</td>
				<td>${list.joinDate}</td>
				<td>${list.grade}</td>
				<td>${list.city}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="footer.jsp" %>












<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h2>홈쇼핑 회원 등록화면</h2>
<form action="shop" method="post">
	<input type="hidden" name="command" value="shop_input">
	<table>
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tr>
			<th>회원번호(자동발생)</th>
			<%-- <td><input type="text" size="20" value="<%= custno %>"></td> --%>
			<td><input type="text" size="20" value="${custno}" readonly="readonly"name="custno"></td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="custname" size="20"></td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone" size="30"></td>
		</tr>
		<tr>
			<th>회원주소</th>
			<td><input type="text" name="address" size="40"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="text" name="joindate" size="20"></td>
		</tr>
		<tr>
			<th>
				고객등급
				<br>(A:VIP, B:일반, C:직원)
			</th>
			<td><input type="text" name="grade" size="20"></td>
		</tr>
		<tr>
			<th>도시코드</th>
			<td><input type="text" name="city" size="20"></td>
		</tr>
	</table>
	<div class="btn_group">
		<button type="submit">등록</button>
		<button type="button">조회</button>
	</div>
</form>
<%@ include file="footer.jsp" %>
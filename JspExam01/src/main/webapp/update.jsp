<%@page import="com.ezen.dao.ShopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="header.jsp" %>
<%
	/* data 가져오기 */
	String custno = request.getParameter("custno");
	Connection conn = ShopDAO.getConnection();
	String custname, phone, address, joindate, grade, city;
	
	String sql = "SELECT * from member_tbl_02 where custno = "+custno;
	ResultSet res = conn.prepareStatement(sql).executeQuery();
	res.next();
	
	custname = res.getString("custname");
	phone = res.getString("phone");
	address = res.getString("address");
	joindate = res.getString("joindate");
	if(joindate.length() > 10) joindate = joindate.substring(0, 10);
	grade = res.getString("grade");
	city = res.getString("city");
%>
<h2>홈쇼핑 회원 등록</h2>
<form action="./action.jsp" method="post">
	<input type="hidden" name="action" value="update">
	<table>
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tr>
			<th>회원번호(자동발생)</th>
			<td><input type="text" name="custno" size="20" value="<%= custno %>" readonly></td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="custname" size="20" value="<%= custname %>"></td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone" size="30" value="<%= phone %>"></td>
		</tr>
		<tr>
			<th>회원주소</th>
			<td><input type="text" name="address" size="40" value="<%= address %>"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="text" name="joindate" size="20" value="<%= joindate %>"></td>
		</tr>
		<tr>
			<th>
				고객등급
				<br>(A:VIP, B:일반, C:직원)
			</th>
			<td><input type="text" name="grade" size="20" value="<%= grade %>"></td>
		</tr>
		<tr>
			<th>도시코드</th>
			<td><input type="text" name="city" size="20" value="<%= city %>"></td>
		</tr>
	</table>
	<div class="btn_group">
		<button type="submit">수정</button>
		<button type="button" onclick="history.back();">목록</button>
	</div>
</form>
<%@ include file="footer.jsp" %>
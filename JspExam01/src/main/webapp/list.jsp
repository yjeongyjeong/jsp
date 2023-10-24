<%@page import="com.ezen.dao.ShopDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<%
			/** 테스트를 위해 샘플 데이터 추가하기
			 *  insert into sys.member_tbl_02 values(10001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01')
			 *  insert into sys.member_tbl_02 values(10002, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '20151206', 'B', '01')
			 *  insert into sys.member_tbl_02 values(10003, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30')
			 *  insert into sys.member_tbl_02 values(10004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151113', 'A', '30')
			 *  insert into sys.member_tbl_02 values(10005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60')
			 *  insert into sys.member_tbl_02 values(10006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '20151211', 'C', '60') 
			 */
			 
			/* 회원정보 list 가져오기 */
			
			Connection conn = ShopDAO.getConnection();
			
			String sql = "SELECT * from member_tbl_02 order by custno asc";
			ResultSet res = conn.prepareStatement(sql).executeQuery();
			String custno, custname, phone, address, joindate, grade, city;
			while (res.next()) {
				custno = res.getString("custno");
				custname = res.getString("custname");
				phone = res.getString("phone");
				address = res.getString("address");
				grade = res.getString("grade");
				city = res.getString("city");
				
				/** 1) joindate에서 time 값을 제외하고 가져온다.
				 *  input  : 2018-07-29 00:00:00
				 *  output : 2018-07-29
				 */
				joindate = res.getString("joindate");
				if(joindate.length() > 10) joindate = joindate.substring(0,10);
				
				/** 2) grade의 A, B, C에 대한 실제 권한을 매핑 */ 
				switch (grade) {
					case "A" : grade = "VIP"; break;
					case "B" : grade = "일반"; break;
					case "C" : grade = "7직원"; break;
				}
		%>
		<tr style="text-align:center;">
			<td><a href="./update.jsp?custno=<%=custno%>"><%= custno %></a></td>
			<td><%= custname %></td>
			<td><%= phone %></td>
			<td><%= address %></td>
			<td><%= joindate %></td>
			<td><%= grade %></td>
			<td><%= city %></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<%@ include file="footer.jsp" %>
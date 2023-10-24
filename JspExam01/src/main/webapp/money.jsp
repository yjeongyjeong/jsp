<%@page import="com.ezen.dao.ShopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="header.jsp" %>
<h2>회원 매출 조회</h2>
<table>
	<colgroup>
		<col width="25%">
		<col width="25%">
		<col width="25%">
		<col width="25%">
	</colgroup>
	<thead>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
	</thead>
	<tbody>
		<%
			/** 테스트를 위해 샘플 데이터 추가하기
			 *  insert into sys.money_tbl_02 values(10001, 20160001, 500, 5, 2500, 'A001', '20160101')
			 *  insert into sys.money_tbl_02 values(10001, 20160002, 1000, 4, 4000, 'A002', '20160101')
			 *  insert into sys.money_tbl_02 values(10001, 20160003, 500, 3, 1500, 'A008', '20160101')
			 *  insert into sys.money_tbl_02 values(10002, 20160004, 2000, 1, 2000, 'A004', '20160102')
			 *  insert into sys.money_tbl_02 values(10002, 20160005, 500, 1, 500, 'A001', '20160103')
			 *  insert into sys.money_tbl_02 values(10003, 20160006, 1500, 2, 3000, 'A003', '20160103')
			 *  insert into sys.money_tbl_02 values(10004, 20160007, 500, 2, 1000, 'A001', '20160104')
			 *  insert into sys.money_tbl_02 values(10004, 20160008, 300, 1, 300, 'A005', '20160104')
			 *  insert into sys.money_tbl_02 values(10004, 20160009, 600, 1, 600, 'A006', '20160104')
			 *  insert into sys.money_tbl_02 values(10004, 20160010, 3000, 1, 3000, 'A007', '20160106')
			 */
			 
			/** 매출정보 list 가져오기
			 *	매출정보와 회원정보를 JOIN 및 집계하여 가져와야 한다.
			    
			    sql  = "SELECT mb.custno, mb.custname, mb.grade, sum(mn.price) as total ";
				sql += "FROM member_tbl_02 mb ";
				sql += "JOIN money_tbl_02 mn on mb.custno = mn.custno ";
				sql += "group by (mb.custno, mb.custname, mb.grade) ";
				sql += "order by total desc";
			 */
			 Connection conn = ShopDAO.getConnection();
			 
			String sql  = "SELECT mb.custno, mb.custname, mb.grade, sum(mn.price) as total ";
			sql += "FROM member_tbl_02 mb,  money_tbl_02 mn ";
			sql += "where mb.custno = mn.custno ";
			sql += "group by (mb.custno, mb.custname, mb.grade) ";
			sql += "order by total desc";
			ResultSet res = conn.prepareStatement(sql).executeQuery();
			String custno, custname, grade, total;
			while (res.next()) {
				custno = res.getString("custno");
				custname = res.getString("custname");
				grade = res.getString("grade");
				total = res.getString("total");
				
				/* grade의 A, B, C에 대한 실제 권한을 매핑 */ 
				switch (grade) {
					case "A" : grade = "VIP"; break;
					case "B" : grade = "일반"; break;
					case "C" : grade = "7직원"; break;
				}
		%>
		<tr style="text-align:center;">
			<td><%= custno %></td>
			<td><%= custname %></td>
			<td><%= grade %></td>
			<td><%= total %></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<%@ include file="footer.jsp" %>
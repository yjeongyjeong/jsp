<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!Connection con = null;
//	PreparedStatement ps = null;
	Statement ps = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";
	String sql = "select * from employee";
	

	%>
<!--	<table width="800" border="3">
		<tr>
			<th>name</th><th>address</th><th>ssn</th>
		</tr>
		 데이터 넣을 표를 다 만들엇으니까 이제 데이터를 불러와야함..! 원래 io는 예외처리 해줌
		 라고 생각햇는데 표를 안만들고 냅다 출력하네... -->
		<%
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, password);
				//연결
//				ps = con.prepareStatement(sql);
				ps = con.createStatement();
				//연결하고 명령준비한걸 ps가 받음
				rs = ps.executeQuery(sql);
				//명령준비한거를 ㄹㅇ로 실행시킨걸 rs가 받음(엔터키를 친다고 생각하면 됨)
				
				out.println("<table>");
				while(rs.next()){
					out.println("<tr>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("<td>" + rs.getString("address") + "</td>");
					out.println("<td>" + rs.getString("ssn") + "</td>");
					out.println("</tr>");
					
				}
				out.println("</table>");
			} catch(Exception e){
				e.getMessage();
			} finally{
				try{ //안열렸을수도 있으니까 예외처리 내에 다시 예외처리함 또한 열린순서 반대로 닫아줌!
					if( rs != null) rs.close();
					if( ps != null) ps.close();
					if( con != null) con.close();
				} catch(Exception e){
					e.getMessage();
				}
			}
		
		%>

</body>
</html>
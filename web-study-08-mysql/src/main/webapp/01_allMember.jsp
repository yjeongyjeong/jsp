<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! /* 선언문  */
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";  => ORACLE url
	String url = "jdbc:mysql://127.0.0.1:3306/ezen"; // => ezen 스키마(DB)명
	String uid = "test";
	String pwd = "1234";
	String sql = "select * from member";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="1" style="background-color: pink">
		<tr>
			<th>이름</th><th>아이디</th><th>암호</th>
			<th>이메일</th><th>전화번호</th><th>권한(1:관리자 0:사용자)</th>
		</tr>	
		
		<%
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // =>ORACLE
			Class.forName("com.mysql.jdbc.Driver"); //DB 연결준비
			con = DriverManager.getConnection(url, uid, pwd); //연결함
			
			System.out.println("mysql연결 성공 : "+ con); // 연결확인
			
			
			stmt = con.createStatement(); //명령준비
			rs = stmt.executeQuery(sql); //명령함
			
			while(rs.next()){ //getString(String columnLabel 오라클 컬럼명)
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>"); //인덱스값으로도 출력이 가능함(대신 순서대로임) -> 근데 알아보기 힘드니까 그냥 컬럼명 사용...
				out.println("<td>" + rs.getString("userid") + "</td>");
				out.println("<td>" + rs.getString("pwd") + "</td>");
				out.println("<td>" + rs.getString("email") + "</td>");
				out.println("<td>" + rs.getString("phone") + "</td>");
				out.println("<td>" + rs.getString("admin") + "</td>");
				out.println("</tr>");
			}
		} catch(Exception e){
			e.getMessage();
		} finally {
			try{ //역순으로 닫기 근데 왜 이 구문까지 try를 한 걸까..
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();				
			}
			catch(Exception e){e.getMessage();}
		}
		%>
		
		
	</table>
	<br>
	<a href="02_addMemberForm.jsp">추가 회원 등록</a>

</body>
</html>
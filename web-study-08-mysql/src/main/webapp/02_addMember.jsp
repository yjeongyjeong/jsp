<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	Connection con = null;
	PreparedStatement ps = null;
	
	String url = "jdbc:mysql://127.0.0.1:3306/ezen";
	String uid = "test";
	String password = "1234";
	String sql = "insert into member values(?,?,?,?,?,?)";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("utf-8"); 
		String name = request.getParameter("name");
		String userid= request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uid, password); //위에서 지정한거랑 충돌날수도있음(String pwd = "tiger"했어서 충돌남..)
			ps = con.prepareStatement(sql);
			
//			String sql = "insert into member values(?,?,?,?,?,?)";
			ps.setString(1, name);
			ps.setString(2, userid);
			ps.setString(3, pwd);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setInt(6,Integer.parseInt(admin)); //db에서 phone char(13)로 설정했기 때문에 int로 받아주기..
			
			int result = ps.executeUpdate();
			System.out.println(result);		
			//result=1이면 성공! 0이면 실패.. 이클립스에서 하는건 알아서 commit됨
			
		}catch(Exception e){
			e.getMessage();
		}finally{
			try{ //파일이 실행되지 않은 경우가 있을 수 있으므로 예외처리내에서 한번 더 해줌
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(Exception e){
				e.getMessage()	;
			}
		}
	%>
	
	<h3>회원가입에 성공하였습니다!</h3>
	<a href="01_allMember.jsp">전체 회원 목록 보기</a>

</body>
</html>
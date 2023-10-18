<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- con, ps, rs 선언(한번만 수행될거라 여기서 선언함) url, user, pwd, sql은 선택사항(근데 선언하는편이 나중에 변경할때 좋겠다!) 
이후 body에서 requestcharsetutf8, 
class.forname(oracle주소) 하고 con, ps, rs 에게 값 주기
con : drivermanager.getconnection(url, user, pwd) 연결
ps : con.prepareStatement(sql) -> rs하고 executeupdate 해줘야함!!
rs : ps.executeQuery(sql) 
try열고 값 받아줌 & 넘겨줌 구문 작성함
catch(ex~ e) e.getme~ 이후 finally구문에서 다시 
try(if !=null이면 닫아주기)-> 연순서반대로! catch마찬가지로 e.getm 
-->
<%!

	Connection con = null;
	PreparedStatement ps = null;
		
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String password = "tiger";
	String sql = "insert into employee values(?,?,?)";

	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--     name varchar2(20), --상품제목
    price number(8), --가격
    description varchar2(100) --상품설명 -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body> 
<!-- 따옴표 치든말든 상관없음 name에서.. id는 라벨기능할때 사용됨 -->
	<form action="ParamServlet" method="post" name="frm">
		<!-- 아이디 : <input type="text" name="id"><br> -->
		<label for="id">아이디 : </label>
		<input type="text" name="id" id="id"><br>
		
		나&nbsp;&nbsp;&nbsp;이 : <input type="text" name=age><br>
		비밀번호 : <input type="password" name=password><br><br>
		내용 : <textarea rows="3" cols="20"></textarea>
		<input type="submit" value="전송" onclick = "return check()">
	<!-- 전송버튼 클릭하면 check 함수가 실행되며 전송이 막힘 -->
	</form>
</body>
</html>
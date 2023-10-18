<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영화장르</h1>
관심있는 영화 장르를 선택하세요.<hr>
<form action="17_paramValues.jsp" method="get">
	<input type="checkbox" name="item" value="스릴러"> 스릴러
	<input type="checkbox" name="item" value="액션"> 액션
	<input type="checkbox" name="item" value="코미디"> 코미디
	<input type="checkbox" name="item" value="로맨스"> 로맨스
	<input type="checkbox" name="item" value="판타지"> 판타지
	<input type="checkbox" name="item" value="드라마"> 드라마 <br><br>
	<input type="submit" value="전송">

</form>
</body>
</html>
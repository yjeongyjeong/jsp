<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- 경로 조심.... -->
  <script type="text/javascript" src="../script/member.js"></script>
<title>Insert title here</title>
</head>
<body>

<h1>로그인</h1>
	<form action="login.do" method="post" name="frm">
    <label for="userid">아이디 : &nbsp;</label>
    <input type="text" class="form-control" id="userid" placeholder="Enter userid" name="userid"><br>
    <label for="pwd">&nbsp;암&nbsp;호 : &nbsp;</label>
    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd"><br>
    <h2 style="color:red;">${message}</h2>
    <button type="submit" class="btn btn-primary" onclick="return loginCheck()">로그인</button>&nbsp;&nbsp;
    <button type="reset" class="btn btn-danger">취소</button>&nbsp;&nbsp;
    <button type="submit" class="btn btn-info" onclick="location.href=join.do">회원가입</button>

  	</form>
    <br>
    ${message}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"/>
<jsp:setProperty name="member" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력된 회원 정보</h1>
<!-- property가 속성명 member는 ...위에서 설정! 여기서 name과 03add에서 name(속성)의미가 좀 다름-->
이름 : <jsp:getProperty property="name" name="member"/>
아이디 : <jsp:getProperty property="userid" name="member"/>
별명 : <jsp:getProperty property="nickname" name="member"/>
비밀번호 : <jsp:getProperty property="pwd" name="member"/>
이메일 : <jsp:getProperty property="email" name="member"/>
전화번호 : <jsp:getProperty property="phone" name="member"/>
<hr>
이름 : <%= member.getName() %>
아이디 : <%= member.getUserid() %>
</body>
</html>
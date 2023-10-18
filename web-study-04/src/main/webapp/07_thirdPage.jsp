<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

하나의 페이지 속성 <%=pageContext.getAttribute("name") %><br>
하나의 요청 속성 <%=request.getAttribute("name") %><br>
하나의 세션 속성 <%=session.getAttribute("name") %><br>
하나의 어플리케이션 속성 <%=application.getAttribute("name") %><br>

<!-- second에서 리다이렉트 방식으로 요청되는 페이지로 first에서 설정한 속성 값을 브라우저에 출력 -->
</body>
</html>
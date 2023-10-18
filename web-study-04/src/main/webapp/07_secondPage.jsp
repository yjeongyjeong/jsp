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

<a href="07_thirdPage.jsp">또 다른 페이지</a>
<!-- first에서 설정한 속성 값을 브라우저에 출력(first에서는 출력할 수 없으므로 콘솔창에 출력해서 확인) 
first페이지 마지막 문장에 secondpage로 포워딩 시켜서 브라우저 실행시키면 secondpage가 보임

first페이지 : 값을 주고 그 값들은 전부 살아있음 포워딩방식으로 이동시킴(페이지값만 유실), 리다이렉트로 페이지 이동(request객체가 새로 생성되어 이전페이지에서 설정한 속성값이 유실됨)
second페이지 : first페이지가 끝났으므로 페이지값이 죽음 요청은 first에서 포워딩했으므로 남아있음
third페이지 : 이전 페이지에서 리다이렉트시킴=> request 객체가 새로생성됨 => 요청 null!세션과 어플리케이션은 남아있음! 단독으로 실행시키는 경우 세션이 끊긴 후(웹부라우저를 닫기 전까지 보관되는 객체) 이므로 어플리케이션에 저장된 속성값만 출력됨 -->


</body>
</html>
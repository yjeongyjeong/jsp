<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = "login.do";
	
	response.sendRedirect(url);
	/* 기본 시작 페이지를 지정해준 것인데 왜 이것이 가능하냐면 톰캣 서버 web.xml에서
	    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
    가 되어있기 때문이다..
    저 코드에 따라 가장먼저 보게되는 파일이 index들이 되어버리는데 나는 여기서 index라고 파일을 만들어서 파일을 읽게함+index파일안에 response.sendRedirect를 해서 url을 바꾼 것.. 따라서 내 기본접속 페이지는 내가 설ㅈ어한 주소인 login.do가 된다.
    */
%>

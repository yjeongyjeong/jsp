<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%! int num0 = 0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		
		List<Integer> number = new ArrayList(); //ㅇ<%@~ 을 통해 위에 삽입됨
		
		out.println(num0);
		out.print(num1 +"+"+ num2 +"=" + add +"\n" + "<br>");
		
		/* out : 객체 안만들고 바로 메서드 사용할 수 잇는 이유 => jsp의 내장 객체라서 가능
				서블릿에서는 printwrite로 만들어서 사용했었음*/
				
		Calendar date = Calendar.getInstance();
		//싱글톤 패턴....?
		SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
		out.println(date);
		out.println( today.format(date.getTime()) );
				
	%>

</body>
</html>
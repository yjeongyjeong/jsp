<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% 
    	int age = Integer.parseInt(request.getParameter("age"));
    	
    	if(age<=19){
    		//중간에 html코드를 넣고싶으면 이렇게 끊어주고 넣어야함..! <%는 자바코드만 들어갈 수 잇으니까..
    %>
    		<h2>19세 미만 입력</h2>
    		<script>
    			alert("19세 미만이므로 입장 불가능!");
    			history.go(-1);
    		</script>
    		
<%    		
    	} else {
    		request.setAttribute("name", "성윤정");
    		RequestDispatcher dis = request.getRequestDispatcher("05_forwardResult.jsp");
    		dis.forward(request, response);
    		
    		/* 
    		위 코드를 이렇게 할 수도 있음
    		request.getRequestDispatcher("05_forwardResult.jsp").forward(request, response); */	
    		
    	}
    %>
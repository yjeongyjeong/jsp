<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form>     
	<table align="center" width="550">
		<tr>
			<td colspan="2" align="center">			 
			 <h3> ��� ���� </h3>
			 <div style="color:red;">${message}</div>
			</td>
		</tr>
		<tr>
			<td align="center">���̵�</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td align="center">��й�ȣ</td>
			<td>${member.pass}</td>
		</tr>
		<tr>
			<td align="center">�̸�</td>
			<td>${member.name}</td>
		</tr>
		
		<tr>
			<td align="center">����</td>
			<td>
			<c:choose>
				<c:when test='${member.lev=="A"}'>���</c:when>
				<c:otherwise>�Ϲ�ȸ��</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td align="center">����</td>
			<td>
			<c:choose>
				<c:when test='${member.gender=="1"}'>����</c:when>
				<c:otherwise>����</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td align="center">��ȭ��ȣ</td>
			<td colspan="3">${member.phone}</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="button" value="���� �������� �̵�" onclick="location.href='main.jsp'">
			</td>
		</tr>	
	</table>
</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="mypage.do" method="post" name="frm">
	<table align="center" width="550">
		<tr>
			<td colspan="2" align="center"> ����������</td>
		</tr>
		<tr>
			<td id="front">���̵�</td>
			<td><input type="text" name="id"
			    value="${loginUser.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<td id="front">��й�ȣ</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td id="front">�̸�</td>
			<td><input type="text" name="name" value="${loginUser.name }"></td>
		</tr>
		<tr>
			<td id="front">����</td>
			<td>
				<select name="lev">
				<c:choose>
					<c:when test="${result==2}">
						<option value="A" selected="selected">���</option>
						<option value = "B">�Ϲ�ȸ��</option>
					</c:when>
					<c:otherwise>					
						<option value="A" >���</option>
						<option value="B" selected="selected">�Ϲ�ȸ��</option>
					</c:otherwise>						
				</c:choose>
				</select>
			</td>
		</tr>
		<tr>
			<td align="center">����</td>
			<td>
			<select name="gender">
			<c:choose>
				<c:when test="${gender==1}">
					<option value = "1" selected="selected">����</option>
					<option value = "2">����</option>
				</c:when>
				<c:otherwise>
				<option value="1" >����</option>
					<option value="2" selected="selected">����</option>
				</c:otherwise>
				</c:choose>
			</select>
			</td>
		</tr>
		<tr>
			<td align="center">��ȭ��ȣ</td>
			<td colspan="3"><input type="text" name="phone" value="${loginUser.phone}"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="����">
				<input type="reset" value="���">
			</td>
		</tr>
	
	</table>
</form>
</body>
</html>
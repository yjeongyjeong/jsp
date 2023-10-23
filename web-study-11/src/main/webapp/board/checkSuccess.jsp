<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
	if(window.name == 'update'){
		window.opener.parent.location.href = "BoardServlet?command=board_update_form&num=${param.num}";
	}else if( window.name == 'delete' ){
		window.opener.parent.location.href = "BoardServlet?command=board_delete&num=${param.num}";
		/* board_delete&num=${param.num} 이 부분에서 delete까지만 받고 뒤에는 변수니까 &로 연결!! */
		
	}
	window.close();
</script>

</body>
</html>
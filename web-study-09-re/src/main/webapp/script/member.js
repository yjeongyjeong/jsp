function loginCheck() {
	/*근데 스페이스바 입력하면 데이터 넘어가게되므로 나중에 잘 막어줘야함 -> or조건으로 넣어봄ㅎㅎ 근데 이러면 스페이스바 여러번 하면 뚫리네 아나...
	아스키 코드로 넣어야할가? 하나라도 있으면 안되도록..? 아니면 그냥 아스키로 안하고 하나라도 있으면 안되도록 해도 될거같기도 하고... => js에서 문자열 포함여부 확인 메서드 사용 document.frm.userid.includes(" ") 했는데 암것도 안나옴 아나..*/
	if (document.frm.userid.value.length == 0 || document.frm.userid.value == " ") {
		/*frm(jsp파일에서 name으로 줌), userid id로 줌*/
		alert("아이디를 입력하세요.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "" || document.frm.pwd.value == " ") {
		alert("암호를 입력하세요.");
		frm.pwd.focus();/*아무것도 주지 말라고*/
		return false;
	}

}

/*아이디 중복 체크 팝업*/
function idCheck() {
	if(document.frm.userid.value == ""){ /*빈칸이면 팝업발생*/
		alert("아이디를 입력하세요.");
		return;
	}
	let url = "idCheck.do?userid="+document.frm.userid.value;
	window.open(url,"_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	/* "_blank_1" => 윈도우에서 새창열겠다는 의미 링크는 http://localhost:8181/web-study-09-re/idcheck.do?userid=somi*/
}
/*아이디 중복 ㄹㅇ로 체쿠*/
function idOk(){
	opener.frm.userid.value = document.frm.userid.value; 
	/*opener란 이 창을 실행시킨 부모창을 의미 => 회원가입 폼*/
	/*부모창(회원가입창에 있는 아이디)에 있는 아이디에 현재창에 있는 아이디를 넣어줌*/
	opener.frm.reid.value = document.frm.userid.value;   
	/*reid라는 히든값에도 아이디중복창에서 통과된 아이디를 넣어줌*/
	self.close();
	/*창 닫음 close()로 사용해야 창이 닫힘!! close만 쓰면 아무런 작동안함...^^*/	
}



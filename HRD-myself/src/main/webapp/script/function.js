function memberCheck(){
	if(document.frm.custname.value.length == 0){
		alert("회원성명이 입력되지 않았습니다.");
		return false;
	}
	if(document.frm.phone.value.length == 0){
		alert("회원전화가 입력되지 않았습니다.");
		return false;
	}
	if(document.frm.address.value.length == 0){
		alert("회원주소가 입력되지 않았습니다.");
		return false;
	}
	if(document.frm.joindate.value.length == 0){
		alert("가입일자가 입력되지 않았습니다.");
		return false;
	}
	if(document.frm.grade.value.length == 0){
		alert("회원등급이 입력되지 않았습니다.");
		return false;
	}
	if(document.frm.city.value.length == 0){
		alert("도시코드가 입력되지 않았습니다.");
		return false;
	}
}
function memberCheckOkay(){
	if(memberCheck == true){
		alert("회원등록이 완료되었습니다!")
	}
}
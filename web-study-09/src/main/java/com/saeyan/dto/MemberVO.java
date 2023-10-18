package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// DB 입력 데이터와 연동

@Getter @Setter @ToString
public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
	
}

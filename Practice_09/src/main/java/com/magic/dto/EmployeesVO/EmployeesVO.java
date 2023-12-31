package com.magic.dto.EmployeesVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* create table employees(
		id varchar2(10) not null,
		pass varchar2(10) not null,
		name varchar2(24),
		lev char(1) default 'A', --A운영자, B일반회원
		enter date default sysdate, --등록일
		gender char(1) default '1', --1남자 2여자
		phone varchar2(30),
		primary key(id)
		); */

@Getter @Setter @ToString
public class EmployeesVO {
	private String id;
	private String pass;
	private String name;
	private String lev;
	private String enter;
	private String gender;
	private String phone;
	
}

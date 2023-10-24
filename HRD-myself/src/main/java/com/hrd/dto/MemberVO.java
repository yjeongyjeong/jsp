package com.hrd.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 *create table member_tbl_02(
    custno number(6) not null primary key,
    custname varchar2(20),
    phone varchar2(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2)
); 

create table money_tbl_02(
    custno number(6) not null,
    salenol number(8) not null,
    pcost number(8),
    amount number(4),
    price number(8),
    pcode varchar2(4),
    sdate date,
    constraint money_tbl_02_PK primary key(custno, salenol),
    foreign key (custno) REFERENCES member_tbl_02(custno)
);
 */
@Getter @Setter @ToString
public class MemberVO {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Timestamp joindate;
	private String grade;
	private String city;

	private int salenol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private String date;
}

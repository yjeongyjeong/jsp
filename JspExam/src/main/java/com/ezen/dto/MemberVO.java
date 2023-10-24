package com.ezen.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * CUSTNO   NOT NULL NUMBER(6)    
CUSTNAME          VARCHAR2(20) 
PHONE             VARCHAR2(13) 
ADDRESS           VARCHAR2(60) 
JOINDATE          DATE         
GRADE             CHAR(1)      
CITY              CHAR(2)   
 */
@Getter
@Setter
@ToString
public class MemberVO {
	private int custNo;
	private String custName;
	private String phone;
	private String address;
	private String joinDate;
	private String grade;
	private String city;
	
}

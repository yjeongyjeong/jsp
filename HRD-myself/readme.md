#DB
create table member_tbl_02(
    custno number(6) not null primary key,
    custname varchar2(20),
    phone varchar2(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2)
);
insert into member_tbl_02 values
(100001, '김행복', '010-1111-2222','서울 동대문구 휘경1동', '20151202', 'A', '01');
insert into member_tbl_02 values
(100002, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '20151206', 'B', '01');
insert into member_tbl_02 values
(100003, '장믿음' ,'010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30');
insert into member_tbl_02 values
(100004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151113', 'A', '30');
insert into member_tbl_02 values
(100005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60');
insert into member_tbl_02 values
(100006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '20151211', 'C', '60');

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
insert into money_tbl_02 values
(100001, 20160001, 500, 5, 2500, 'A001', '20160101');
insert into money_tbl_02 values
(100001, 20160002, 1000, 4,4000, 'A002', '20160101');
insert into money_tbl_02 values
(100001, 20160003, 500, 3, 1500, 'A008', '20160101');

-- create SEQUENCE member_tbl_02_seq start with 100006 increment by 1;

select * from member_tbl_02;
select * from money_tbl_02;

CREATE SEQUENCE member_tbl_seq
       INCREMENT BY 1
       START WITH 100006
       MINVALUE 1
       MAXVALUE 999999
       NOCYCLE
       NOCACHE
       NOORDER;
-- 시퀀스 삭제 시 DROP SEQUENCE emp_seq

commit;

#커넥션 풀 server
<Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
              username="scott" password="tiger" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/>
              
#커넥션 풀 jsp
<%
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); //추가한 리소스 name과 동일
	Connection conn = ds.getConnection();
	
	System.out.println("conn : " + conn);
	%>

#get connection
		public Connection getConnection() throws SQLException {
			Connection conn = null;
			try {
				Context initContext = new InitialContext();
				Context envContext;
				envContext = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); //추가한 리소스 name과 동일
				conn = ds.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return conn; // try구문이 지역변수라서 에러남 -> 밖에 빼줌
		}

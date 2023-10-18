create table member(
    name varchar2(20),
    userid varchar2(10),
    pwd varchar2(10),
    email varchar2(20),
    phone char(13),
    admin number(1) default 0, --0사용자, 1관리자
    primary key(userid)
    );
    
insert into member values('이소미', 'somi', '1234', 
'somi@naver.com', '010-111-2222', 0);
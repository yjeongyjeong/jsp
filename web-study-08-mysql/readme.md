use ezen;

create table member(
name varchar(20) primary key,
userid varchar(10),
pwd varchar(10),
email varchar(20),
phone char(13),
admin int(1) default 0
);
insert into member values('이소미', 'somi', '1234', 'somi@naver.com', '010-111-2222', 0);
insert into member values('김윤승', 'mi', '1234', 'mi@naver.com', '010-222-2222', 0);
insert into member values('하상우', 'sang12', '1234', 'sang12@naver.com', '010-222-3333', 1);



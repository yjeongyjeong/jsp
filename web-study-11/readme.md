#DB table
create table board (
    num number(5) primary key,
    pass varchar2(30) not null,
    name varchar2(30) not null,
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readcount number(4) default 0,
    writedate date default sysdate
);
create SEQUENCE board_seq start with 1 increment by 1;

insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '성윤정', 'pink@anver.com',
'1234', '첫방문', '반갑습니다');
insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '성윤정', 'pink@anver.com',
'1234', '김밥', '맛있어요.');
insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '전수빈', 'raccon@nate.com',
'3333', '고등애', '일식입니다.');
insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '전원지', 'one@nate.com',
'1111', '갯골마을', '돼지삼겹살이 맛있습니다!');

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
package com.myself.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myself.member.dto.MemberVO;

public class MemberDAO {
	private MemberDAO() { };
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext;
		envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	public static void Close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if( rs != null ) rs.close();
			if( ps != null ) ps.close();
			if( conn != null ) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	오버로딩(매개변수가 다름)
	public static void Close(Connection conn, PreparedStatement ps) {
		try {
			if( ps != null ) ps.close();
			if( conn != null ) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	로그인 로직 : 먼저 아이디와 패스워드를 입력받고 db에 둘 다 전달해서 일치하면(userCheck) getMember라는 메서드를 통해 아이디를 넣고 정보를 가져와서 세션에 로그인 된 회원의 정보를 저장함 
	public int userCheck(String userid, String pwd) {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pwd from member where userid= ?";
				try {
					conn = getConnection();
					ps = conn.prepareStatement(sql);
					ps.setString(1, userid);
					rs = ps.executeQuery();
					if(rs.next()) { //일단 값이 있는지 먼저...
					if( rs.getString("pwd").equals(pwd)) {
						result = 1; //아이디가 있고 비번이 일치
					} else {
						result = 0; //아이디가 있는데 비번이 불일치
					}
					} else {
						result = -1; //아이디가 아예 없음
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					MemberDAO.Close(conn, ps, rs);
				}
		return result;
	}
	
	public MemberVO getOneMember(String userid) {
		MemberVO vo = new MemberVO(); //여기서 만드는게 맞겠지? 밑에서 만들면 한번 돌때마다 계속 초기화되니까.. 아니겠지....?ㅠ
		/*
		 *  NAME            VARCHAR2(20) 
			USERID NOT NULL VARCHAR2(10) 
			PWD             VARCHAR2(10) 
			EMAIL           VARCHAR2(20) 
			PHONE           CHAR(13)     
			ADMIN           NUMBER(1)
		 */
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(Integer.parseInt(rs.getString("admin")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MemberDAO.Close(conn, ps, rs);
		}
	
		return vo;
	}
	
	
}

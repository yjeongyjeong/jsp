package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

//DB와 연동 (DB 접속)
//싱글톤
public class MemberDAO {
	private MemberDAO() {

	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getinstance() {
		return instance;
	}
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	//로그인 성공 여부 체크(id,pwd 있으면 성공!)
	public int userCheck(String userid, String pwd) {
		String sql = "select pwd from member where userid = ?";		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				if( rs.getString("pwd").equals(pwd) ) { //id의 pwd가 동일하다면
					result = 1;
				}else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//특정 userid와 일치하는 모든 데이터 vo 담기
	public MemberVO getMember(String userid) { //VO에 있는 값(=테이블 컬럼)을 가져온다는 의미
		String sql = "select * from member where userid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin")); //admin이라는 컬럼을 int로 가져옴
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	//userid 중복 체크!
	public int confirmID(String userid) {
		return 0;
	}
	//데이터 입력(MemberVO )
	public void insertMember(MemberVO vo) {
		
	}
	//데이터 업데이트(수정 MemberVO)
	public void updateMember(MemberVO vo) {
		
	}
	
	
}

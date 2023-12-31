package com.magic.dao.EmployeesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO.EmployeesVO;

public class EmployeesDAO {
private EmployeesDAO() {
}

private static EmployeesDAO instance = new EmployeesDAO();

public static EmployeesDAO getInstance() {
	return instance;
}
public Connection getConnection() throws Exception {
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); //추가한 리소스 name과 동일
	Connection conn = ds.getConnection();
	return conn;
}

//로그인 회원인지
public int userCheck(String id, String pwd) {
	int result = -1;
	String sql = "select pwd from Employees where id = ?";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		conn = getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery(); //id를 DB에 입력해서 정보 가져옴
		
		if( rs.next() ) { //=> id가 DB에 있다
			if(rs.getString("pwd").equals(pwd)) {
				result = 1;
				//아이디가 디비에 있고 pwd도 DB와 입력값이 동일할 때
			} else {
				result = 0;
				//아이디가 디비에 있지만 패스워드가 다를 때
			}
		} else { //아이디에서 읽어올 정보가 없음 => 아이디가 없을 때 아닌가? 맞당!
			result = -1;
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if( rs!= null ) rs.close();
			if( ps !=null ) ps.close();
			if( conn !=null ) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	return result;
}
//로그인 하면 유저 정보를 가져와서 세션이 만료되기 전까지 유저와 관련된 정보를 기억하도록 함!!! => 값을 가져와야하니까 rs 필요
public EmployeesVO getEmployees(String id) {
	EmployeesVO vo = null;
	String sql = "select * from Employees where id = ?";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		conn = getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		//반환해줄 vo에 rs에 있는 값들을 넣어줘야하니까.. vo는 set, rs가서 getString으로 컬럼 가져오기
		vo.setId(rs.getString("id"));
		vo.setPass(rs.getString("pass"));
		vo.setName(rs.getString("name"));
		vo.setLev(rs.getString("lev"));
		vo.setEnter(rs.getString("enter"));
		vo.setGender(rs.getString("gender"));
		vo.setPhone(rs.getString("phone"));
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if( rs != null ) rs.close();
			if( ps != null ) ps.close();
			if( conn != null ) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return vo;
}
//마이페이지-정보수정
public int updateEmployees(EmployeesVO vo) {
	return 0;
}
//사원등록(관리자만 가능)
public int insertEmployees(EmployeesVO vo) {
	return 0;
}
}

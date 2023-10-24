package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ezen.dto.MemberVO;
import com.ezen.dto.ShopVO;

public class ShopDAO {
	
	private static ShopDAO instance = new ShopDAO();
	
	private ShopDAO() {}
	
	public static ShopDAO getInstance() {
		return instance;
	}
	
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();
			if(conn != null ) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null ) pstmt.close();
			if(conn != null ) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int getSelectCustNo() {
		int result=0;
		String sql  = "select custno from member_tbl_02 where rownum <= 1 order by custno desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = ShopDAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("custno");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ShopDAO.close(conn, pstmt, rs);
		}
		
		return result;
	}

	public int insertShop(MemberVO vo) {
		int result = 0;
		String sql  = "insert into member_tbl_02 "
				+ "values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ShopDAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustNo());
			pstmt.setString(2, vo.getCustName());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getJoinDate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getCity());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ShopDAO.close(conn, pstmt);
		}
		
		return result;
	}

	public List<MemberVO> shopList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo = null;
		
		String sql  = "select * from member_tbl_02 order by custno desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ShopDAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setCustNo(rs.getInt(1));
				vo.setCustName(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setAddress(rs.getString(4));
				vo.setJoinDate(rs.getString(5));
				vo.setGrade(rs.getString(6));
				vo.setCity(rs.getString(7));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ShopDAO.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

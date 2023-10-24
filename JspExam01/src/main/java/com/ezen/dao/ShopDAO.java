package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ezen.dto.MemberVO;
import com.ezen.dto.ShopVO;

public class ShopDAO {
	private static ShopDAO instance = new ShopDAO();

	private ShopDAO() {
	};

	public static ShopDAO getInstance() {
		return instance;
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;

		Context initContext = new InitialContext();
		Context envContext;
		envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle"); // 추가한 리소스 name과 동일
		conn = ds.getConnection();

		return conn;
	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//오버로딩! 매개변수가 다른것
	public static void close(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getSelectCustNo() {
		int result = 0;

		String sql = "select custno from member_tbl_02 where rownum<= 1 order by custno desc";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ShopDAO.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt("custno");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ShopDAO.close(conn, ps, rs);
		}

		return result; // custno가 바로 담기게 됨
	}

	public int insertShop(MemberVO vo) {
		int result = 0;

		String sql = "insert into member_tbl_02 values(" 
		+ "?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = ShopDAO.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, vo.getCustno());
			ps.setString(2, vo.getCustname());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getAddress());
			ps.setString(5, vo.getJoindate());
			ps.setString(6, vo.getGrade());
			ps.setString(7, vo.getCity());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ShopDAO.close(conn, ps);
		}

		return result;
	}

	public List<MemberVO> shopList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo = null;
		
		String sql = "select * from member_tbl_02 order by custno desc";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ShopDAO.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getString("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				
//				System.out.println(vo);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ShopDAO.close(conn, ps, rs);
		}
		return list;
	}

}

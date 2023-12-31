package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
//private 생성자로 만들어서 싱글톤 패턴-> MemberDAO 하나만 생성하겠다
	private MemberDAO() {	}

//다른데서 불러오려면 static이여야 함
	public static MemberDAO getInstance() {
//		return new MemberDAO(); -> 이렇게 두면 getInstance할때마다 객체가 생성됨! 하나만 생성되어서 접근하는게 아님!! 따라서 객체를 클래스에서 생성하고 여기에는 생성된 객체를 전달
		return instance;
	}
	
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
	
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pwd from member where userid = ?";
		Connection conn = null; //연결시키는 애
		PreparedStatement psmt = null; //sql넘겨주는 애
		ResultSet rs = null; //db에서 열 한 줄을 의미하는 느낌 => 한줄을 불러오는 느낌? 그래서 그 열에서 이제 next()메서드 사용해서 값을 가져오는 그런느낌..
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid); //DB에 전달될때 이름
			rs = psmt.executeQuery();
			
//			값을 출력시키는거면 while로 쭉 출력해도 됨
			if( rs.next() ) {
				if(rs.getString("pwd").equals(pwd)) {// db에있는 "pwd"와 입력한값을 가져온 pwd가 같은지(살짝 rs는 DB에있는 기분)
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
				if( rs != null ) rs.close();
				if( psmt != null ) psmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	//id받아서 vo로 정보 불러오기
	public MemberVO getMember(String userid) {
		MemberVO vo = null;
		String sql = "select * from member where userid = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//아이디를 넣어서 vo로 데이터를 가져와야 함 -> 
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
				String name = rs.getString("name"); //rs에서 넘겨진 값중에 name이란 애를 가져와서 String name에 넣겠다는 의미 따라서 getString은 DB테이블 컬럼명과 동일해야 함 / usercheck 먼저 통과해어 getmember가 실행되므로 rs null나오면 다시봐야함..!
				String id = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");

				vo = new MemberVO();
				vo.setName(name);
				vo.setUserid(id);
				vo.setEmail(email);
				vo.setPwd(pwd);
				vo.setPhone(phone);
				vo.setAdmin(admin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( psmt != null ) psmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	//아이디 중복 체크
	public int confirmId(String userid) {
		int result = -1;
		String sql = "select userid from member where userid=?";
//		값이 잇으면 중복 없으면 중복아님
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null; //정보를 불러와서 확인해야하니까 rs가 존재
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
				result = 1; //중복
			} else {
				result = -1; //아이디 중복 아님
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(psmt!=null) psmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int insertMember(MemberVO vo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement ps = null;
//			rs는 필요없음 값을 불러올 필요가 없으니까
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			//1. DB 연결
			conn = getConnection();
			//2. sql구문을 오라클에 전달
			ps = conn.prepareStatement(sql);
			//3. 맵핑
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getUserid());
			ps.setString(3, vo.getPwd());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getPhone());
			ps.setInt(6, vo.getAdmin());
			
			result = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int updateMember(MemberVO vo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member set name=?, pwd=?, email =?, phone =?, admin =? where userid = ?";
//			rs는 필요없음 값을 반환
//		반드시 where..
		
		try {
			//1. DB 연결
			conn = getConnection();
			//2. sql구문을 오라클에 전달
			ps = conn.prepareStatement(sql);
			//3. 맵핑
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getPhone());
			ps.setInt(5, vo.getAdmin());
			ps.setString(6, vo.getUserid());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
}


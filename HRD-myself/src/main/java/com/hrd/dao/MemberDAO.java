package com.hrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dao.ShopDAO;
import com.hrd.dto.MemberVO;
import com.hrd.util.DBUtil;

public class MemberDAO {
	private MemberDAO(){ };
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	public List<MemberVO> selectAllMembers() {
		List<MemberVO> memberList = new ArrayList<MemberVO>(); // vo가 몇개일지 모르니까
		
		String sql = "select * from member_tbl_02";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO(); //list에 넣을 vo 틀 -> while안에서 돌려야 새로 받아서 배열넣음 아니면 그냥 계속 마지막값만 넣어짐

				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getTimestamp("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				
				memberList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return memberList;
	}


	public MemberVO selectOneByCustno(String custno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02 where custno =?";
		MemberVO vo = new MemberVO();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(custno)); //숫자로 넣어줌..
			rs = ps.executeQuery();
			
			if( rs.next() ) {
			vo.setCustno(rs.getInt("custno"));
			vo.setCustname(rs.getString("custname"));
			vo.setPhone(rs.getString("phone"));
			vo.setAddress(rs.getString("address"));
			vo.setJoindate(rs.getTimestamp("joindate"));
			vo.setGrade(rs.getString("grade"));
			vo.setCity(rs.getString("city"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		
		return vo;
	}


	public int updateMember(MemberVO vo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member_tbl_02 set custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";
		
		try {
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getCustname());
		ps.setString(2, vo.getPhone());
		ps.setString(3,  vo.getAddress());
		ps.setTimestamp(4, vo.getJoindate());
		ps.setString(5, vo.getGrade());
		ps.setString(6, vo.getCity());
		ps.setInt(7, vo.getCustno());
		
		result = ps.executeUpdate();
		System.out.println("트라이 구문 돌아요");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return result;
	}
	
	public int getSelectCustNo() {
		int result = 0;

		String sql = "select custno from member_tbl_02 where rownum<= 1 order by custno desc"; 
		//번호 역순으로(큰거에서 작은 순으로) 정렬해서 가장 위에(최신번호)만 가져옴 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt("custno");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}

		return result; // custno가 바로 담기게 됨
	}
	


	public int joinMember(MemberVO vo) {
		int result = -1;
		String sql = "insert into member_tbl_02 values(member_tbl_seq.nextval ,?,?,?,?,?,?)";
		//시퀀스 따라가지 말고 마지막번호 +1 하는 방법 생각해보기
		//->쿼리문으로 마지막 시퀀스 번호 가져와서 넣게 보내준 다음에 그 번호를 넣어줌
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.getCustname());
			ps.setString(2, vo.getPhone());
			ps.setString(3,  vo.getAddress());
			ps.setTimestamp(4, vo.getJoindate());
			ps.setString(5, vo.getGrade());
			ps.setString(6, vo.getCity());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
		return result;
	}


	public List<MemberVO> selectPriceMember() {
		String sql  = "SELECT mb.custno, mb.custname, mb.grade, sum(mn.price) as total ";
        sql += "FROM member_tbl_02 mb,  money_tbl_02 mn ";
        sql += "where mb.custno = mn.custno ";
        sql += "group by (mb.custno, mb.custname, mb.grade) ";
        sql += "order by total desc";
        
        List<MemberVO> memberList = new ArrayList<MemberVO>();
        MemberVO vo = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
        	conn = DBUtil.getConnection();
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	
        	while( rs.next() ) {
        		vo = new MemberVO();
        
				/*
				 * vo.setCustno(rs.getInt("custno")); vo.setCustname(rs.getString("custname"));
				 * vo.setGrade(rs.getString("grade")); vo.setPrice(rs.getInt("price"));
				 * // 등급을 못가져옴 why,,,
				 */        		
        		vo.setCustno(rs.getInt(1));
        		vo.setCustname(rs.getString(2));
        		vo.setGrade(rs.getString(3));
        		vo.setPrice(rs.getInt(4));// 숫자로 넣으면 인식됨 근데 왜그런지는 모르겠음
        		
        		memberList.add(vo);
        	}
		} catch (Exception e) {
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return memberList;
	}
	

	
}

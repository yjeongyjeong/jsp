package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;
import com.saeyan.util.DBManager;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() { }
	public static BoardDAO getInstance() { //얘도 static이 필요한가 모르겠다? ->필요한듯...
		return instance;
	}
	//전체조회
	public List<BoardVO> selectAllBoards() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;
		String sql = "select * from board order by num desc";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection(); //DB연결(로그인)
			ps = conn.prepareStatement(sql); //sql구문 입력
			rs = ps.executeQuery(); //sql구문 실행(결과를 참조하는 중)
			
			while(rs.next()) {
				vo = new BoardVO();
				
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPass(rs.getString("pass"));
				vo.setTitle(rs.getString("title"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	
	public BoardVO selectOneByNum(int num) {
		BoardVO vo = new BoardVO();
		
		String sql = "select * from board where num=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection(); //DB연결(로그인)
			ps = conn.prepareStatement(sql); //sql구문 입력
			ps.setInt(1, num);
			rs = ps.executeQuery(); //sql구문 실행(결과를 참조하는 중)
			
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPass(rs.getString("pass"));
				vo.setTitle(rs.getString("title"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		
		return vo;
	}
	
	
	//데이터 등록
	public int insertBoard(BoardVO vo) {
		/*
		 *  NUM       NOT NULL NUMBER(5)      
			PASS      NOT NULL VARCHAR2(30)   
			NAME      NOT NULL VARCHAR2(30)   
			EMAIL              VARCHAR2(30)   
			TITLE              VARCHAR2(50)   
			CONTENT            VARCHAR2(1000) 

		 */
		
		int result = -1;
		String sql = "insert into board(num, pass, name, email, title, content) "/*<- 한칸 띄어쓰기 해줘야함!*/
				+ "values(board_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection(); //DB연결(로그인)
			ps = conn.prepareStatement(sql); //sql구문 입력
			
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTitle());
			ps.setString(5, vo.getContent());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
		
		return result;
	}
	
	
}

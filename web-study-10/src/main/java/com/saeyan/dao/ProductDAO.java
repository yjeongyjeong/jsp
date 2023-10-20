package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.saeyan.dto.ProductVO;

public class ProductDAO {

	private ProductDAO() {	}
	//다른데서 불러오려면 static이여야 함
	private static ProductDAO instance = new ProductDAO();
	//private 생성자로 만들어서 싱글톤 패턴-> ProductDAO 하나만 생성하겠다

		public static ProductDAO getInstance() {
//			return new ProductDAO(); -> 이렇게 두면 getInstance할때마다 객체가 생성됨! 하나만 생성되어서 접근하는게 아님!! 따라서 객체를 클래스에서 생성하고 여기에는 생성된 객체를 전달
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
	
		
		public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
			try {
				if(rs != null) rs.close();
				if(ps != null ) ps.close();
				if(conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		public static void close(Connection conn, PreparedStatement ps) {
			try {
				if(ps != null ) ps.close();
				if(conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		DB 전체 DATA 검색 -> 몇개일지 모르니까 리스트에 담아서 넘겨받겠다는 의미
		public List<ProductVO> selectAllProduct(){
			List<ProductVO> productList = new ArrayList<ProductVO>(); //몇개 받을 지 모르니까...
			String sql = "select * from Product order by code desc";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
//				값을 가져와야하는데 어케 가져올까...
				while(rs.next()) {
					ProductVO vo = new ProductVO();
					vo.setName(	rs.getString("name") );
					vo.setCode(rs.getInt("code"));
					vo.setDescription( rs.getString("description"));
					vo.setPictureurl(rs.getString("pictureurl"));
					vo.setPrice( rs.getInt("price"));
					
					productList.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//close메서드를 사용하려면 뭘 생성해야하지./.? -> static이니까.... 메서드를 사용하려면 해당클래스.메서드...
				ProductDAO.close(conn, ps, rs);
			}
			return productList;
			
			/*
			 * 			List<ProductVO> productList = new ArrayList<ProductVO>();
//			arraylist는 가변배열
			
			String sql = "select * from product order by code desc"; //code를 기준으로 최신글이 제일 먼저오도록 내림차순
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					ProductVO vo = new ProductVO();
					vo.setCode(rs.getInt("code"));
					vo.setName(rs.getString("name"));
					vo.setPrice(rs.getInt("price"));
					vo.setDescription(rs.getString("description"));
					vo.setPictureurl(rs.getString("pictureurl"));
//					값 가져와서 vo안에 담아줌					
					productList.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ProductDAO.close(conn, ps, rs);
			}
			return productList;
			 */
		}
//		기본키 CODE로 해당하는 데이터만 검색
		public ProductVO selectProductByCode(String code) {
			ProductVO vo = new ProductVO();
			String sql = "select * from Product where code =?";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(code));
				rs = ps.executeQuery();
				
				if(rs.next()) { //가져올값이 하나니까 if로 받음
				vo.setName(	rs.getString("name") );
				vo.setCode(rs.getInt("code"));
				vo.setDescription( rs.getString("description"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setPrice( rs.getInt("price"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//close메서드를 사용하려면 뭘 생성해야하지./.? -> static이니까.... 메서드를 사용하려면 해당클래스.메서드...
				ProductDAO.close(conn, ps, rs);
			}
			return vo;
		}
		
//		id, password 체크
		public int userCheck(String userid, String pwd) {
			return 0;
		}
//		아이디 존재 여부 체크 -> 값이 있는지 없는지만 보면 되니까 int로 받으면 됨
		public int confirmID(String userid) {
			return 0;
		}
//		데이터 추가
		public int insertProduct(ProductVO vo) {
			String sql = "insert into product values(product_seq.nextval, ?, ?, ?, ? )";
			Connection conn = null;
			PreparedStatement ps = null;
			int result = -1;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				
				//맵핑
				/*
				 *  	name varchar2(100),
    					price number(8),
					    pictureurl varchar(50),
					    description varchar(1000),
				 */
				ps.setString(1, vo.getName());
				ps.setInt(2, vo.getPrice());
				ps.setString(3, vo.getPictureurl());
				ps.setString(4, vo.getDescription());
				
				result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ProductDAO.close(conn, ps);
			}
			
			return result;
		}
//		데이터 업데이트
		public int updateProduct(ProductVO vo) {
			String sql = "update product set name =?, price =?, pictureurl=?, description=? where code =?";
			Connection conn = null;
			PreparedStatement ps = null;
			int result = -1;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				
				//맵핑
				/*
				 *  	name varchar2(100),
    					price number(8),
					    pictureurl varchar(50),
					    description varchar(1000),
				 */
				ps.setString(1, vo.getName());
				ps.setInt(2, vo.getPrice());
				ps.setString(3, vo.getPictureurl());
				ps.setString(4, vo.getDescription());
				ps.setInt(5, vo.getCode());
				
				result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ProductDAO.close(conn, ps);
			}
			
			return result;
		}

		public int deleteProduct(int code) {

			String sql = "delete from product where code =?";
			Connection conn = null;
			PreparedStatement ps = null;
			int result = -1;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				
				//맵핑
				/*
				 *  	name varchar2(100),
    					price number(8),
					    pictureurl varchar(50),
					    description varchar(1000),
				 */
				ps.setInt(1, code);

					
				result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ProductDAO.close(conn, ps);
			}
			
			return result;
		}
		
		
		
}
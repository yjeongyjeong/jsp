package com.saeyan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	
	
}

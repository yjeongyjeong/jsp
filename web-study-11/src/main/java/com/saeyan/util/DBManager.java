package com.saeyan.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBManager {
		public static Connection getConnection() throws SQLException {
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
}

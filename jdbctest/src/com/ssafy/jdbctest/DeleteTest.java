package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DeleteTest {
	
	public DeleteTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
	}
	
	private int deleteByProductId(String product_id) throws SQLException {
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Resultset rs = null;
		
		try {
			conn = makeConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("delete from product \n");
			sql.append("where product_id = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product_id);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt!=null)
				pstmt.close();
			if (conn!=null)
				conn.close();
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws SQLException {
		DeleteTest dt = new DeleteTest();
		
		String product_id = "GS30";
		int cnt = dt.deleteByProductId(product_id);
		System.out.println(cnt);
	}

}

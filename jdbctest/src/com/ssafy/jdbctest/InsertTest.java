package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	
	public InsertTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection makeConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
	}
	
	private int registerProduct(String productId, String productName, int price, String color) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = makeConnection(); // db 연결
			StringBuilder sql = new StringBuilder();
			sql.append("insert into product (product_id, product_name, price, color, register_date) \n");
			sql.append("values (?, ?, ?, ?, now())");
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productId);
			pstmt.setString(2, productName);
			pstmt.setInt(3, price);
			pstmt.setString(4, color);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		int cnt = it.registerProduct("GS25", "갤럭시 23 울트라", 1350000, "보라");
		
		if (cnt!=0) {
			System.out.println("상품 등록 성공");
		} else {
			System.out.println("상품 등록 실패");
		}
		
	}


}

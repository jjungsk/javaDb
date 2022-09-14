package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// product ID 가 GS24인 상품의 가격을 50,000원 인상 하고 색상을 흰색으로 변경하는 프로그램
public class UpdateTest {
	
	public UpdateTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
	}
	
	private int updateProduct(String productId, int upPrice, String color) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = makeConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("update jdbc_test.product \n");
			sql.append("set price = price + ?, color = ? \n");
			sql.append("where product_id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, upPrice);
			pstmt.setString(2, color);
			pstmt.setString(3, productId);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		int cnt = ut.updateProduct("GS24", 50000, "빨주노초파남보");
		
		if (cnt!=0)
			System.out.println("성공");
		else
			System.out.println("실패");
	}

}

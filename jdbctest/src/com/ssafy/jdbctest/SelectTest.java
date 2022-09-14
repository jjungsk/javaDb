package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 모든 상품 검색
// product_id = GS23인 상품 검색
// 가격이 150만원 이상인 상품 검색
// 
public class SelectTest {


	public SelectTest() {
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
	
	private List<ProductDto> allProductList() {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select product_id, product_name, price, color, register_date \n");
			sql.append("from product \n");
			sql.append("order by price");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getString("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setColor(rs.getString("color"));
				productDto.setRegisterDate(rs.getString("register_date"));
				
				list.add(productDto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	private ProductDto searchByProductId(String productId) {
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select product_id, product_name, price, color, register_date \n");
			sql.append("from product \n");
			sql.append("where product_id = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				productDto = new ProductDto();
				productDto.setProductId(rs.getString("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setColor(rs.getString("color"));
				productDto.setRegisterDate(rs.getString("register_date"));
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return productDto;
	}
	
	private List<ProductDto> searchByPrice(int price) {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select product_id, product_name, price, color, register_date \n");
			sql.append("from product \n");
			sql.append("where price >= ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, price);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getString("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setColor(rs.getString("color"));
				productDto.setRegisterDate(rs.getString("register_date"));
				
				list.add(productDto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	private int countProduct(int price) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(product_id) \n");
			sql.append("from product \n");
			sql.append("where price >= ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, price);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return cnt;
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		System.out.println("모든 상품 검색");
		List<ProductDto> list = st.allProductList();
		
		for (ProductDto pdto: list)
			System.out.println(pdto);
		
		String pid = "GS23";
		System.out.println(pid + "검색");
		
		ProductDto productDto = st.searchByProductId(pid);
		
		if (productDto != null)
			System.out.println(productDto);
		else
			System.out.println("그런상품 없습니다.");
		
		int price = 1500000;
		System.out.println("가격이" + price +" 이상인 상품");
		List<ProductDto> listp = st.searchByPrice(price);
		
		for (ProductDto pdto: listp)
			System.out.println(pdto);
		
		int cnt = st.countProduct(price);
		
		System.out.println(cnt);
		
		
		
	}

}

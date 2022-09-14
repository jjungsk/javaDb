package com.ssafy.jdbctest;

public class DriverLoadingTest {
	
	public DriverLoadingTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("정상");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DriverLoadingTest();
		
		
		
	}

}

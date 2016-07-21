package com.srivastava.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/amit?autoReconnect=true&useSSL=false"
				,"root","amit123456");
		if(con!=null){
			System.out.println("Connection Created...");
		}
		return con;
		
	}
	
	public boolean isUserExist(LoginDTO loginDTO) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = this.getConnection();
			pstmt = con.prepareStatement("select userid,password from user_mst where userid=? and password=?");
			pstmt.setString(1, loginDTO.getUserid());
			pstmt.setString(2, loginDTO.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
				
			}
			if(con!=null){
				con.close();
			}
		}
		return false;
	}

}

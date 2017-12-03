/*Class name: LoginDAo.java
 * date: 15/11/2017
 * @reference:  http://javaandj2eetutor.blogspot.ie/2014/01/login-application-using-jsp-servlet-and.html
 * @author: Kamil Robakowski 16138520
 * @comments: Majority of code in this class has been reused and sourced from blog referenced.
 * author modified:
 * parameters required to connect to database to match development environment requirements
 * exceptions handling method where stack trace printing was replaced with error message 
 * code comments 
*/

package com.amzi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public static boolean validate(String name, String pass) {

		//declaration of variables requires to connect to database
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "database1";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "dbUser";
		String password = "zaq1@wsx";
		
		//connecting to database
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
		
			//prepared statement for query to be executed in database 	
			pst = conn.prepareStatement("select * from users where userName=? and pass=?");
			pst.setString(1, name);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println("Something went wrong");
		} finally {
			if (conn != null) {
				try {
					conn.close(); //closing connection to database
				} catch (SQLException e) {
					System.out.println("Something went wrong"); //displaying error id exception occurs
				}
			}
			if (pst != null) {
				try {
					pst.close(); //closing prepares statement 
				} catch (SQLException e) {
					System.out.println("Something went wrong"); //displaying error id exception occurs
				}
			}
			if (rs != null) {
				try {
					rs.close(); //closing result set
				} catch (SQLException e) {
					System.out.println("Something went wrong"); //displaying error id exception occurs
				}
			}
		}
		return status; //class returns true / false if name and pass are found / not found in the database
	}
}
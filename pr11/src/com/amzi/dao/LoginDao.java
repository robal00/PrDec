package com.amzi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "database1";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "kamilr00";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn
                    .prepareStatement("select * from users where userName=? and pass=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                	System.out.println("Something went wrong");
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                	System.out.println("Something went wrong");
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                	System.out.println("Something went wrong");
                }
            }
        }
        return status;
    }
}
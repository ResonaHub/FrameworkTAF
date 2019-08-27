package com.resonantiatechnologie.amazon.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
		Statement sta= con.createStatement();
		ResultSet set =sta.executeQuery("select * from PomData");
	}
}

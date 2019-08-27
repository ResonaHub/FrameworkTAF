package com.resonantiatechnologie.amazon.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySqlReader {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySqlReader.mySqlReader();
	}
	
	public static List mySqlReader() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/frameworkdata", "root", "root");
		Statement statement= con.createStatement();
		ResultSet resultset= statement.executeQuery("SELECT * FROM PomData;\r\n");
		List logindata= new ArrayList();
		while(resultset.next()) {
			logindata.add(resultset.getString(1));
			logindata.add(resultset.getString(2));
		}
		System.out.println(logindata);
		return logindata;
	}
}

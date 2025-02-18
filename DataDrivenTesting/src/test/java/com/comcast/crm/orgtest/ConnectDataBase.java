package com.comcast.crm.orgtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ConnectDataBase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      Driver driver=new Driver();
        DriverManager.registerDriver(driver);
	Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","root");
Statement	sta	=con.createStatement();
		String query="select from employe";
	ResultSet	result=sta.executeQuery(query);
		while(result.next()) {
			
			System.out.println(result.getInt(1)+""+result.getString(2));
			
		}
		
	}

}

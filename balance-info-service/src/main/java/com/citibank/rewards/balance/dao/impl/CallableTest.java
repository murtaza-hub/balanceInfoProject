package com.citibank.rewards.balance.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/citibank";
		String user = "root";
		String password = "system";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		//System.out.println(con.getClass());
		String psql_query="{call getBalance(?,?,?,?)}";
		CallableStatement cs=con.prepareCall(psql_query);
		
		cs.setString(1, "cc");
		cs.setString(2, "555055505550");
		
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.execute();
		
		System.out.println("resp-code :- "+cs.getString(3));
		System.out.println("resp-message :- "+cs.getString(4));
		if((cs.getString(3).equals("000")) && cs.getString(4).equals("SUCCESS")){
		ResultSet rs=cs.executeQuery();
		//System.out.println(rs.getClass().getCanonicalName());
		while(rs.next()) {
			
			System.out.println(rs.getString(1)+ " -:- "+ rs.getString(2)+" -:-  "+rs.getString(3)+ " -:- "+ rs.getString(4)+" -:-  "+rs.getString(5));
		}}
	}
}







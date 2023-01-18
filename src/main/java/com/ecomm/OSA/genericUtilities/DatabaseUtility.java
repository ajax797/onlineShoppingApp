package com.ecomm.OSA.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility
{
	Connection conn=null;
	public void connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(IPathConstants.dBurl, IPathConstants.dBusername, IPathConstants.dBpassword);
	}
	
	public String executeQueryAndGetData(String query,String colnmIndex,String expdata) throws SQLException
	{
		ResultSet result = conn.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(colnmIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expdata+" project is created");
			return expdata;
		}
		else
		{
			System.out.println("project not created");
			return "";
		}
		
	}
	public void disconnectDB() throws SQLException
	{
		conn.close();
	}

}

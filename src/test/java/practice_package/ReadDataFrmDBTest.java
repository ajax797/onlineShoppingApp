package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrmDBTest {

	public static void main(String[] args) throws SQLException
	{
		
		Connection conn=null;
		try 
		{
		
			Driver driver = new Driver();
		
	//1)Register to the dB
			DriverManager.registerDriver(driver);
		
	//2)get connection for dB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45aj", "root", "ajax");
		
	//3)issue create statement
			Statement state = conn.createStatement();
			String query = "select * from stinfo;";
		
	//4)execute query
			ResultSet result = state.executeQuery(query);
		
			while(result.next())
				{
					System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
				}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{		
	//5)close the dB
			conn.close();
			System.out.println("database closed successfully");
		}
		
		
		
	}

}

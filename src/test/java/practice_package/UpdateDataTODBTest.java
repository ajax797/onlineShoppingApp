package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataTODBTest {

	public static void main(String[] args) throws SQLException
	{
		
		Connection conn=null;
		int result=0;
		try 
		{
		
			Driver driver = new Driver();
		
	//1)Register to the dB
			DriverManager.registerDriver(driver);
		
	//2)get connection for dB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45aj", "root", "ajax");
		
	//3)issue create statement
			Statement state = conn.createStatement();
			String query = "insert into stinfo values('diksha','btm','sql',4);";
		
	//4)execute query
			result = state.executeUpdate(query);
		
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{	
			if (result==1)
			{
				System.out.println("Data inserted successfully");
				
			}
			else
			{
				System.out.println("Data not inserted");
			}
	//5)close the dB
			conn.close();
		}
		
		
		
	}

}

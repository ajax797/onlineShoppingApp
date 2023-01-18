package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataToRMGDBTest
{

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
		conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
	//3)issue create statement
		Statement state = conn.createStatement();
		String query = "insert into project values('OSA','AJ','12/12/22','Online_shopping_application','in-progress',3);";
	//4)execute query
		result = state.executeUpdate(query);
		}
		//catch (Exception e) 
		//{
			
		//}
		finally
		{
	//5)close the dB
		if(result==1)
		{
			System.out.println("Data successfully inserted");
		}
		else
		{
			System.out.println("Data not insereted");
		}
		conn.close();
		}
	}

}

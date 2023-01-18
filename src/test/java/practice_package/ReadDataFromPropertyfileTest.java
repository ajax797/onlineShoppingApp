package practice_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyfileTest {

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/java/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String adminUrl = prop.getProperty("Aurl");
		String adminUsername = prop.getProperty("Ausername");
		String adminPassword = prop.getProperty("Apassword");
		String userUrl = prop.getProperty("Uurl");
		String userUsername = prop.getProperty("Uusername");
		String userPassword = prop.getProperty("Upassword");
		
		System.out.println(adminUrl);
		System.out.println(adminUsername);
		System.out.println(adminPassword);
		System.out.println();
		System.out.println(userUrl);
		System.out.println(userUsername);
		System.out.println(userPassword);
		
	}

}

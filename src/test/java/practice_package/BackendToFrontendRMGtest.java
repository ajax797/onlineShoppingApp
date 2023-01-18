package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;


public class BackendToFrontendRMGtest {

	public static void main(String[] args) throws InterruptedException, SQLException
	{
		
		Connection conn=null;
		int result =0;
		try 
		{
			
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = conn.createStatement();
		result = state.executeUpdate("insert into project values('OSA01','ajax','19/12/22','Oln Shping App','Created',4)");
		}
		catch (Exception e) 
		{
			
		}
		finally
		{
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
		
		
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
	String un = "rmgyantra";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("usernmae")))).sendKeys(un);
	String pwd = "rmgy@9999";
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		Thread.sleep(2000);
		List<WebElement> projectnames = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']//tr/td[2]"));
		Thread.sleep(2000);
		for (WebElement projectname : projectnames)
		{
			if(projectname.getText().equals("Oln Shping App"))
			{
				System.out.println("Presnt");
			}
		}
		
		
		
	}
}

package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;


public class FrontendToBackendRMGtest {

	public static void main(String[] args) throws InterruptedException, SQLException
	{
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
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	String pn = "Online Shopping App";
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(pn);
	String pm = "deepthi";
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(pm);
		
		WebElement status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel = new Select(status);
	String option="Created";
		sel.selectByValue(option);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		Connection conn=null;
		try 
		{
			
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("select * from project where project_name='Online Shopping App';");
		while(result.next())
		{
			System.out.println(result.getString(1)+"     "+result.getString(2)+"     "+result.getString(3)+"     "+result.getString(4));
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
		conn.close();
		}
	}

}

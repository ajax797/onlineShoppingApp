package practice_package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {

	public static void main(String[] args) throws Throwable
	{
		// TODO Auto-generated method stub
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/extent.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		ExtentTest test = report.createTest("ExtentReport");
		
		WebDriver driver=new FirefoxDriver();
		test.log(Status.INFO, "Browser is launched");
		driver.get("https://www.facebook.com");
		test.log(Status.INFO, "Facebook is launched");
		String title = driver.getTitle();
		if(title.contains("acebook"))
		{
			test.log(Status.PASS, "Welcomepage is launched");
		}
		else
		{
			test.log(Status.FAIL, "WElcomepage is not launched");
		
		}
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("user");
		test.log(Status.INFO, "Email is entered");
		driver.findElement(By.id("pass")).sendKeys("pass");
		test.log(Status.INFO, "password is entered");
		report.flush();

	}

}

package utility_OSA_Admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecomm.OSA.genericUtilities.ExcelUtility;
import com.ecomm.OSA.genericUtilities.FileUtility;
import com.ecomm.OSA.genericUtilities.JavaUtility;
import com.ecomm.OSA.genericUtilities.WebdriverUtility;

public class TC_admin_02Test 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		int rand = jLib.getRandomNum();
		String adminUrl = fLib.getPropertyValue("Aurl");
		String adminUsername = fLib.getPropertyValue("Ausername");
		String adminPassword = fLib.getPropertyValue("Apassword");
		
		
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(adminUrl);
		 wLib.waitForPageLaod(driver);
		 wLib.maximizeWindow(driver);
		  driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
		  driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword); 
		  driver.findElement(By.xpath("//button")).click();
		  
		  driver.findElement(By.xpath("//a[contains(.,'Create')]")).click();
		  String categoryName = eLib.readDataFromExcel("CatTestdata", 0, 1)+rand;
		  String categorydescription = eLib.readDataFromExcel("CatTestdata", 1, 1);
		  
		  driver.findElement(By.name("category")).sendKeys(categoryName);
		  driver.findElement(By.name("description")).sendKeys(categorydescription);
		  driver.findElement(By.name("submit")).click();
		  
		  driver.findElement(By.xpath("//a[contains(.,'Sub Category ')]")).click();
		  WebElement catDrop =driver.findElement(By.xpath("//select[@name='category']")); 
		  wLib.select(categoryName, catDrop);
		  Thread.sleep(500);
		  String subcategoryName = eLib.readDataFromExcel("SubTestdata", 0, 1)+rand;
		  driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subcategoryName);
		  driver.findElement(By.xpath("//button[.='Create']")).click();	  
		  driver.findElement(By.xpath("//a[contains(.,'Insert Product ')]")).click();
		  Thread.sleep(500);
		  WebElement catDrop1 =driver.findElement(By.xpath("//select[@name='category']")); 
		wLib.select(categoryName, catDrop1);  
		  WebElement subcatDrop =driver.findElement(By.xpath("//select[@name='subcategory']")); 
		wLib.select(subcategoryName, subcatDrop);
		   HashMap<String, String> prodData = eLib.getList("ProductTestdata", 0, 1);
		   String expectedresult="";
		 for (Entry<String, String> e:prodData.entrySet())
		 {
			String key = e.getKey();
			String value = e.getValue();
			driver.findElement(By.name(key)).sendKeys(value+rand);
			if(key.equals("productName"))
			{
				expectedresult = value+rand;
			}
		 }
		  
		  WebElement productavailability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
		wLib.select("In Stock", productavailability);
		  driver.findElement(By.name("productimage1")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img1.jpg"); 
		  driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img2.png"); 
		  driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img3.bmp");
		  driver.findElement(By.xpath("//button[.='Insert']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Products ')]")).click();
		
		driver.findElement(By.xpath("//input")).sendKeys(expectedresult);
		driver.findElement(By.xpath("//td[.='"+expectedresult+"']/..//a[1]")).click();
		String Uexpectedresult = "";
		for (Entry<String, String> e1:prodData.entrySet())
		 {
			String key = e1.getKey();
			String value = e1.getValue();
			WebElement ele = driver.findElement(By.name(key));
			ele.clear();
			ele.sendKeys("updated"+value+rand);
			if(key.equals("productName"))
			{
				Uexpectedresult ="updated"+value+rand;
			}
		 }
		driver.findElement(By.xpath("//button[.='Update']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Products ')]")).click();
		driver.findElement(By.xpath("//input")).sendKeys(Uexpectedresult);
		String ActualResult = driver.findElement(By.xpath("//td[text() ='"+Uexpectedresult+"']")).getText();
		
		
		
		if(ActualResult.equals(Uexpectedresult))
			{
				System.out.println("Details of "+ActualResult+" is successfully updated.");
			}
			else
			{
				System.out.println("failed");
			}
		driver.quit();
			
	}

}

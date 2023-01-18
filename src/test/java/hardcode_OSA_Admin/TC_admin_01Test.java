package hardcode_OSA_Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TC_admin_01Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Random ran = new Random();
		int rand = ran.nextInt(100);
		
		FileInputStream fis1 = new FileInputStream("./src/test/java/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String adminUrl = prop.getProperty("Aurl");
		String adminUsername = prop.getProperty("Ausername");
		String adminPassword = prop.getProperty("Apassword");
		
		
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(adminUrl);
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//a[contains(.,'Create')]")).click();
		driver.findElement(By.name("category")).sendKeys("categoryName"+rand);
		driver.findElement(By.name("description")).sendKeys("categorydescription");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[contains(.,'Sub Category ')]")).click();
		WebElement catDrop = driver.findElement(By.xpath("//select[@name='category']"));
		Select categorydd = new Select(catDrop);
		categorydd.selectByVisibleText("categoryName"+rand);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("subcategoryName"+rand);
		driver.findElement(By.xpath("//button[.='Create']")).click();
		
		driver.findElement(By.xpath("//a[contains(.,'Insert Product ')]")).click();
		Thread.sleep(2000);
		WebElement catDrop1 = driver.findElement(By.xpath("//select[@name='category']"));
		Select categorydd1 = new Select(catDrop1);
		categorydd1.selectByVisibleText("categoryName"+rand);
		WebElement subcatDrop = driver.findElement(By.xpath("//select[@name='subcategory']"));
		Select subcategorydd = new Select(subcatDrop);
		Thread.sleep(2000);
		subcategorydd.selectByVisibleText("subcategoryName"+rand);
		driver.findElement(By.name("productName")).sendKeys("ProductName"+rand);
		String ExpectedResult = "ProductName"+rand;
		driver.findElement(By.name("productCompany")).sendKeys("productCompanyName");
		driver.findElement(By.name("productpricebd")).sendKeys("100"+rand);
		driver.findElement(By.name("productprice")).sendKeys("80"+rand);
		driver.findElement(By.name("productDescription")).sendKeys("productDescription");
		driver.findElement(By.name("productShippingcharge")).sendKeys("productShippingcharge");
		WebElement productavailability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
		Select productavailabilitydd = new Select(productavailability);
		Thread.sleep(2000);
		productavailabilitydd.selectByVisibleText("In Stock");
		driver.findElement(By.name("productimage1")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img1.jpg");
		Thread.sleep(2000);
		driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img2.png");
		Thread.sleep(2000);
		driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img3.bmp");
		driver.findElement(By.xpath("//button[.='Insert']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Products ')]")).click();
		driver.findElement(By.xpath("//input")).sendKeys("ProductName"+rand);
		String ActualResult = driver.findElement(By.xpath("//td[text() ='"+"ProductName"+rand+"']")).getText();
		
		
		if(ActualResult.equals(ExpectedResult))
		{
			System.out.println(ActualResult+" is successfully created.");
		}
		else
		{
			System.out.println("failed");
		}
		
		
		
		
		
		
		
		
		
		


	}

}

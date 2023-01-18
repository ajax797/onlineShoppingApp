package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WriteMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		FileInputStream fis1 = new FileInputStream("./src/test/java/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String adminUrl = prop.getProperty("Aurl");
		String adminUsername = prop.getProperty("Ausername");
		String adminPassword = prop.getProperty("Apassword");
		
		
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(adminUrl);
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(4000);
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		driver.quit();
		
		
		
		
		
		FileInputStream fis2 = new FileInputStream("./src/test/java/OSA_TestCommonData.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet("Sheet2");
		for(int i=0;i<links.size();i++)
		{
			String linkvalue = links.get(i).getAttribute("href");
			sheet.createRow(i).createCell(0).setCellValue(linkvalue);
			
		}
		
		
		
		FileOutputStream fout = new FileOutputStream("./src/test/java/OSA_TestCommonData.xlsx");
		book.write(fout);
		
		
		
	}

}

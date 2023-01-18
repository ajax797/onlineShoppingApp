package pom_OSA_Admin;

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

import objectRepo_Admin.AdminHomePage;
import objectRepo_Admin.AdminLoginPage;
import objectRepo_Admin.CategoryPage;
import objectRepo_Admin.InsertProductPage;
import objectRepo_Admin.SubCategoryPage;

public class TC_admin_02_Edit_Product_Details_Test 
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
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginAsAdmin(adminUsername, adminPassword);
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getCreateCategory().click();
		String categoryName = eLib.readDataFromExcel("CatTestdata", 0, 1)+rand;
		String categorydescription = eLib.readDataFromExcel("CatTestdata", 1, 1);
		CategoryPage cp = new CategoryPage(driver);
		cp.createCategory(categoryName, categorydescription);
		ahp.getSubCategory().click();
		String subcategoryName = eLib.readDataFromExcel("SubTestdata", 0, 1)+rand;
		SubCategoryPage scp = new SubCategoryPage(driver);
		scp.createSubcategory(subcategoryName, categoryName);
		ahp.getInsertProduct().click();
		HashMap<String, String> productDetails = eLib.getList("ProductTestdata", 0, 1);
		InsertProductPage ip = new InsertProductPage(driver);
		String expectedresult = ip.insertProduct(driver, rand, categoryName, subcategoryName, productDetails);  
		ahp.getManageProduct().click();
		
		driver.findElement(By.xpath("//input")).sendKeys(expectedresult);
		driver.findElement(By.xpath("//td[.='"+expectedresult+"']/..//a[1]")).click();
		String Uexpectedresult = "";
		for (Entry<String, String> e1:productDetails.entrySet())
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
		
		ahp.getManageProduct().click();
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

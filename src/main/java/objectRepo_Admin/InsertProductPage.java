package objectRepo_Admin;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecomm.OSA.genericUtilities.WebdriverUtility;

public class InsertProductPage 
{
	@FindBy(xpath = "//select[@name='category']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement subcategoryDropdown;
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCompany")
	private WebElement productCompany;
	
	@FindBy(name = "productpricebd")
	private WebElement productpricebeforeDiscount;
	
	@FindBy(name = "productprice")
	private WebElement productpriceafterDiscount;
	
	@FindBy(name = "productDescription")
	private WebElement productDescription;
	
	@FindBy(name = "productShippingcharge")
	private WebElement productShippingcharge;
	
	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement productAvailabilityDropdown;
	
	@FindBy(name = "productimage1")
	private WebElement productimage1;
	
	@FindBy(name = "productimage2")
	private WebElement productimage2;
	
	@FindBy(name = "productimage3")
	private WebElement productimage3;
	
	@FindBy(xpath = "//button[.='Insert']")
	private WebElement insertButton;
	
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getSubcategoryDropdown() {
		return subcategoryDropdown;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCompany() {
		return productCompany;
	}

	public WebElement getProductpricebeforeDiscount() {
		return productpricebeforeDiscount;
	}

	public WebElement getProductpriceafterDiscount() {
		return productpriceafterDiscount;
	}

	public WebElement getProductDescription() {
		return productDescription;
	}

	public WebElement getProductShippingcharge() {
		return productShippingcharge;
	}

	public WebElement getProductAvailabilityDropdown() {
		return productAvailabilityDropdown;
	}

	public WebElement getProductimage1() {
		return productimage1;
	}

	public WebElement getProductimage2() {
		return productimage2;
	}

	public WebElement getProductimage3() {
		return productimage3;
	}

	public WebElement getInsertButton() {
		return insertButton;
	}
	
	public String insertProduct(WebDriver driver,int rand,  String categoryName, String subcategoryName, HashMap<String, String> productDetails) throws InterruptedException
	{
		WebdriverUtility weblib = new WebdriverUtility();
		weblib.select(categoryName, getCategoryDropdown());
		weblib.select(subcategoryName, getSubcategoryDropdown());
		String expectedresult="";
		 for (Entry<String, String> e:productDetails.entrySet())
		 {
			String key = e.getKey();
			String value = e.getValue();
			driver.findElement(By.name(key)).sendKeys(value+rand);
			if(key.equals("productName"))
			{
				expectedresult = value+rand;
			}
		 }
		  weblib.select("In Stock", getProductAvailabilityDropdown());
		  getProductimage1().sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img1.jpg"); 
		  getProductimage2().sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img2.png"); 
		  getProductimage3().sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img3.bmp");
		  getInsertButton().click();
		  return expectedresult;
	
	}
	
	
	

}

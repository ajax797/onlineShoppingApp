package objectRepo_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecomm.OSA.genericUtilities.WebdriverUtility;

public class SubCategoryPage
{
	@FindBy(xpath = "//select[@name='category']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//input[@name='subcategory']")
	private WebElement subCategory;
	
	@FindBy(xpath = "//button[.='Create']")
	private WebElement createButton;
	
	public SubCategoryPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getSubCategory() {
		return subCategory;
	}

	public WebElement getCreateButton() {
		return createButton;
	}
	
	public void createSubcategory(String subcategoryName, String categoryName) throws InterruptedException 
	{
		WebdriverUtility weblib = new WebdriverUtility();
		WebElement dd = getCategoryDropdown();
		weblib.select(categoryName, dd);
		getSubCategory().sendKeys(subcategoryName);
		getCreateButton().click();
		
		
	}
}

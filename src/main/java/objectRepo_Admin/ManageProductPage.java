package objectRepo_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage 
{
	@FindBy(xpath = "//input")
	private WebElement searchTextfield;
	
	public ManageProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}
	

}

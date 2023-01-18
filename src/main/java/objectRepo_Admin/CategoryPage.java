package objectRepo_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage 
{
	@FindBy(name = "category")
	private WebElement categoryName;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	public CategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryName() {
		return categoryName;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void createCategory(String categoryName,String categorydescription)
	{
		getCategoryName().sendKeys(categoryName);
		getDescription().sendKeys(categorydescription);
		getSubmitButton().click();
	}
	

}

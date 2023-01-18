package objectRepo_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysOrderPage
{
	@FindBy(xpath = "//input")
	private WebElement searchText;
	
	@FindBy(xpath = "//select[@size='1']")
	private WebElement entryNumber;
	
	@FindBy(xpath = "(//a[@role='button'])[2]")
	private WebElement nextIcon;
	
	@FindBy(xpath = "(//a[@role='button'])[1]")
	private WebElement previousIcon;
	
	public TodaysOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getEntryNumber() {
		return entryNumber;
	}

	public WebElement getNextIcon() {
		return nextIcon;
	}

	public WebElement getPreviousIcon() {
		return previousIcon;
	}
	

}

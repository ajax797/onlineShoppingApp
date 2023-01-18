package objectRepo_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage
{
	@FindBy(xpath = "//a[contains(.,'Create')]")
	private WebElement createCategory;
	
	@FindBy(xpath = "//a[contains(.,'Sub Category ')]")
	private WebElement subCategory;
	
	@FindBy(xpath = "//a[contains(.,'Insert Product ')]")
	private WebElement insertProduct;
	
	@FindBy(xpath = "//a[contains(.,'Manage Products ')]")
	private WebElement manageProduct;
	
	@FindBy(xpath = "//a[.='User Login Log ']")
	private WebElement userLoginInfo;
	
	@FindBy(xpath = "(//a[contains(.,'Logout')])[2]")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//a[contains(.,'Order Management')]")
	private WebElement orderManagement;
	
	@FindBy(xpath = "//a[contains(.,'Today')]")
	private WebElement todaysOrder;
	
	@FindBy(xpath = "//a[contains(.,'Pending')]")
	private WebElement pendingOrder;
	
	@FindBy(xpath = "//a[contains(.,'Delivered')]")
	private WebElement deliveredOrder;
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getCreateCategory() {
		return createCategory;
	}

	public WebElement getSubCategory() {
		return subCategory;
	}

	public WebElement getInsertProduct() {
		return insertProduct;
	}

	public WebElement getManageProduct() {
		return manageProduct;
	}

	public WebElement getUserLoginInfo() {
		return userLoginInfo;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getOrderManagement() {
		return orderManagement;
	}

	public WebElement getTodaysOrder() {
		getOrderManagement().click();
		return todaysOrder;
	}

	public WebElement getPendingOrder() {
		getOrderManagement().click();
		return pendingOrder;
	}

	public WebElement getDeliveredOrder() {
		getOrderManagement().click();
		return deliveredOrder;
	}

	
}

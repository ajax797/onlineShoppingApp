package objectRepo_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage 
{
	@FindBy(xpath = "//input[@id='inputEmail']")
	private WebElement adminUsername;
	
	@FindBy(xpath = "//input[@id='inputPassword']")
	private WebElement adminPassword;
	
	@FindBy(xpath = "//button")
	private WebElement LoginButton;
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminUsername() {
		return adminUsername;
	}

	public WebElement getAdminPassword() {
		return adminPassword;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	//Business Library
	
	public void loginAsAdmin(String adminUsername, String adminPassword)
	{
		this.adminUsername.sendKeys(adminUsername);
		this.adminPassword.sendKeys(adminPassword);
		LoginButton.click();
	}
	
}

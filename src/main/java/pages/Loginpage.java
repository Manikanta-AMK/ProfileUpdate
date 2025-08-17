package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genriclib.basePage;

public class Loginpage extends basePage {
	
	public Loginpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='usernameField']") WebElement txtUsername;
	@FindBy(xpath="//input[@id='passwordField']") WebElement txtPassword;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btnLogin;
	
	public void enterUsernameAndPasswordAndLogin(String username, String password)
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

	
}

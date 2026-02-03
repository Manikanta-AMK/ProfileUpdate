package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genriclib.basePage;

public class homePage extends basePage{

	public homePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='naukri user profile img']") WebElement iconUsername;
	@FindBy(xpath="//a[@class=\"nI-gNb-info__sub-link\"]") WebElement linkViewAndUpdateProfile;
	
	public void clickOnUserIcon()
	{
		iconUsername.click();
	}
	
	public void clickOnViewAndUpdateProfileLink()
	{
		linkViewAndUpdateProfile.click();
	}
	
	
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genriclib.basePage;

public class profilePage extends basePage{

	public profilePage(WebDriver driver)
	{
		super(driver);
	}
	
//	@FindBy(xpath = "//input[@id='attachCV']") WebElement uploadResumeInput;
    @FindBy(xpath="//input[@class=\"dummyUpload typ-14Bold\"]") WebElement resumeupload;
    @FindBy(xpath="//p[@class='msg']") WebElement successMsg;
    @FindBy(xpath="//span[@class='typ-14Medium mod-date-val']") WebElement updateToToday;
    @FindBy(xpath="//div[@class='s12 typ-16Bold']") WebElement txtResume;
    
    // Method to upload file
    public void clickOnUploadResume() 
    {
    	resumeupload.click();
    }
	
    public void uploadResume(String filePath) 
    {
    	resumeupload.sendKeys(filePath);
    }
    
    public WebElement MsgSuccess() 
    {
    	return successMsg;
    }
    
    public boolean profileUpdateToToday() 
    {
    	return successMsg.isDisplayed();
    }
	
    public WebElement getTextResume() 
    {
    	return successMsg;
    }
	
}

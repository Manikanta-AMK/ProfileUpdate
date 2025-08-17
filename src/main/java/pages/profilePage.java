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
	
	@FindBy(xpath = "//input[@class='dummyUpload typ-14Bold']") 
    WebElement uploadResumeInput;

    // Method to upload file
    public void uploadResume(String filePath) {
        uploadResumeInput.sendKeys(filePath);
    }
	
	
}

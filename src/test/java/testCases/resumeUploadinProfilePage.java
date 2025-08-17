package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



import genriclib.basetest;
import pages.Loginpage;
import pages.homePage;
import pages.profilePage;

public class resumeUploadinProfilePage extends loginTestCase {

	homePage hp;
	Loginpage lp;
	profilePage pp;

//	@Test(groups={"Regression","Sanity","Smoke","Master"})
//	public void loginTest() throws InterruptedException {
//		try {
//			
//			hp = new homePage(driver);
//			lp = new  Loginpage(driver);
//			pp = new profilePage(driver);
//			
//			System.out.println("Launched url is "+ driver.getCurrentUrl());
//			
//			log.info("******* Started TC_03_Resume Upload Testcase *******");
//			lp.enterUsernameAndPasswordAndLogin(prop.getProperty("username"), prop.getProperty("password"));
//			log.info("login credentials enterd and logged into the account");
//			hp.clickOnUserIcon();
//			log.info("clicked on user icon");
//			hp.clickOnViewAndUpdateProfileLink();
//			log.info("clicked on ViewAndUpdateProfileLink");
//			String path = "C:\\Users\\phani\\Downloads\\Manikanta_Arige.pdf";
//			pp.uploadResume(path);
//			log.info("clicked on UpdateResumeLink");
//			
////			// Locate file input element
////	        WebElement uploadElement = driver.findElement(By.id("file-upload"));
////
////	        // Provide the file path directly
////	        uploadElement.sendKeys("C:\\Users\\phani\\Downloads\\Manikanta_Arige.pdf");
//
//	        // Click on upload button
//	        driver.findElement(By.id("file-submit")).click();
//			
//		} catch (Exception e) {
//			Assert.fail();
//		}
//		log.info("******* Finished TC_03_Resume Upload Testcase *******");
//	}
//	
	
	@Test(groups={"Regression","Sanity","Smoke","Master"})
	public void loginTest() throws InterruptedException {
	    try {
	        hp = new homePage(driver);
	        lp = new Loginpage(driver);
	        pp = new profilePage(driver);

	        System.out.println("Launched url is " + driver.getCurrentUrl());

	        log.info("******* Started TC_03_Resume Upload Testcase *******");
	        lp.enterUsernameAndPasswordAndLogin(prop.getProperty("username"), prop.getProperty("password"));
	        log.info("login credentials entered and logged into the account");

	        hp.clickOnUserIcon();
	        log.info("clicked on user icon");
	        hp.clickOnViewAndUpdateProfileLink();
	        log.info("clicked on ViewAndUpdateProfileLink");
	        

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='dummyUpload typ-14Bold']")));
			
	        // ✅ Upload resume
	        pp.uploadResume("C:\\Users\\phani\\Downloads\\Manikanta_Arige.pdf");
	        log.info("resume uploaded successfully");

	        // Optional: Verify if resume upload success message appears
	        // WebElement successMsg = driver.findElement(By.xpath("//div[contains(text(),'Upload successful')]"));
	        // Assert.assertTrue(successMsg.isDisplayed());

	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	    log.info("******* Finished TC_03_Resume Upload Testcase *******");
	}

	
	
}

package testCases;

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

public class homePagetestcase extends loginTestCase {

	homePage hp;
	Loginpage lp;

	@Test(groups={"Regression","Sanity","Smoke","Master"})
	public void loginTest() throws InterruptedException {
		try {
			
			hp = new homePage(driver);
			lp = new  Loginpage(driver);
			
			System.out.println("Launched url is "+ driver.getCurrentUrl());
			
			log.info("******* Started TC_02_homepage Testcase *******");
			lp.enterUsernameAndPasswordAndLogin(prop.getProperty("username"), prop.getProperty("password"));
			log.info("login credentials enterd and logged into the account");
			hp.clickOnUserIcon();
			log.info("clicked on user icon");
			hp.clickOnViewAndUpdateProfileLink();
			log.info("clicked on ViewAndUpdateProfileLink");
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleIs("Mynaukri"));

			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, "Mynaukri", "title is not matching");
			log.info("profilepage is displayed");

			
		} catch (Exception e) {
			Assert.fail("Test failed due to: " + e.getMessage());
		}
		log.info("******* Finished TC_02_homepage Testcase *******");
	}
}

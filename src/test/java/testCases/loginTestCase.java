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

public class loginTestCase extends basetest {

	Loginpage lp;

	@Test(groups={"Regression","Sanity","Smoke","Master"})
	public void loginTest() throws InterruptedException {
		try {
			
			lp = new Loginpage(driver);
			
			System.out.println("Launched url is "+ driver.getCurrentUrl());
			
			log.info("******* Started TC_01_Login Testcase *******");
			Assert.assertEquals(driver.getTitle(), "Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com", "title is not matching");
			
			lp.enterUsernameAndPasswordAndLogin(prop.getProperty("username"), prop.getProperty("password"));
			log.info("login credentials enterd and logged in");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleIs("Home | Mynaukri"));

			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, "Home | Mynaukri", "title is not matching");
			log.info("Homepage is displayed");

			
		} catch (Exception e) {
			Assert.fail("Test failed due to: " + e.getMessage());
		}
		log.info("******* Finished TC_01_Login Testcase *******");
	}
}

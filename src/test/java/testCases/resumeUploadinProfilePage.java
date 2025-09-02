package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genriclib.basetest;
import pages.Loginpage;
import pages.homePage;
import pages.profilePage;

public class resumeUploadinProfilePage extends basetest {

    homePage hp;
    Loginpage lp;
    profilePage pp;
    WebDriverWait wait;

    @Test(priority = 1, groups = {"Regression","Sanity","Smoke","Master"})
    public void clickOnUpdatePrifileLink() {
        try {
            hp = new homePage(driver);
            lp = new Loginpage(driver);
            pp = new profilePage(driver);

            log.info("******* Started TC_03_Resume Upload Testcase *******");
            lp.enterUsernameAndPasswordAndLogin(prop.getProperty("username"), prop.getProperty("password"));
            log.info("Login successful with provided credentials");

            hp.clickOnUserIcon();
            log.info("Clicked on user icon");
            hp.clickOnViewAndUpdateProfileLink();
            log.info("Clicked on ViewAndUpdateProfileLink");

            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='dummyUpload typ-14Bold']")));

           

        } catch (Exception e) {
            Assert.fail("Test method failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void uploadResume() throws IOException, AWTException, InterruptedException {
        try {
        	
        	 pp.clickOnUploadResume();
             log.info("Clicked on upload resume link");
             
            // ✅ Copy file path to clipboard
            String filePath = "C:\\Users\\phani\\Downloads\\Manikanta Resume.pdf";
            StringSelection fileSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelection, null);

            // ✅ Use Robot to paste and submit
            Robot rb = new Robot();
            rb.delay(2000);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            log.info("Resume uploaded successfully");

            // ✅ Wait for success message
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(pp.MsgSuccess()));
            Assert.assertTrue(successMsg.isDisplayed(), "Resume upload confirmation not found!");
            log.info("Success message is displayed");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to: " + e.getMessage());
        }
        log.info("******* Finished TC_03_Resume Upload Testcase *******");
    }
}

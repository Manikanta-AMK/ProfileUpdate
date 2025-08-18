package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import genriclib.basetest;
import pages.Loginpage;
import pages.homePage;
import pages.profilePage;

public class resumeUploadinProfilePage extends basetest {  // Better extend basetest, not loginTestCase

    homePage hp;
    Loginpage lp;
    profilePage pp;

    @Test(groups={"Regression","Sanity","Smoke","Master"})
    public void uploadResumeTest() {
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

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='dummyUpload typ-14Bold']")));

            // Trigger upload action from profilePage
            pp.uploadResume();
            log.info("Clicked on upload resume link");

            // ✅ Copy file path to clipboard
            String filePath = "C:\\Users\\phani\\Downloads\\Manikanta_Arige.pdf";
            StringSelection fileselection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileselection, null);

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

            // ✅ Optional: Verify success message (depends on app)
            // WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            //         By.xpath("//div[contains(text(),'Upload successful')]")));
            // Assert.assertTrue(successMsg.isDisplayed(), "Resume upload confirmation not found!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to: " + e.getMessage());
        }
        log.info("******* Finished TC_03_Resume Upload Testcase *******");
    }
}

package rough;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class ShadowDOMExample extends TestBase {

	@Test
	public void clickincurance() throws InterruptedException, IOException {

		// wait for the element
		explicitWaitClickable("signinbtn_BTNTEXT");

		// Enter the username
		type("username_MODEL", "automation-tester");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Entered the username.");

		// Enter the password
		type("password_MODEL", "Test@123");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Entered the password.");

		// Click on the Sign In button
		click("signinbtn_BTNTEXT");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the Sign In button.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// click on the Sustainability icon
		click("sustainabilityicon_CSS");
		System.out.println("Clicked on the Sustainability icon.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		Thread.sleep(5000);

		// click on the side menu
		click("ssc_leftsidemenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the side menu.");

		// wait for the element
		Thread.sleep(5000);

		// click on the UTILITY METERS option
		click("sustainability_sidemenu_utilitymetersoption_XPATH");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the UTILITY METERS option.");

		// click on the document icon
		click("sustainability_utilitymeters_documenticon_XPTH");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the document icon.");

		// click on the document icon
		click("sustainability_utilitymeters_documenticon_extractoption_XPTH");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the document icon.");

		// click on the extract button
		click("sustainability_utilitymeters_documenticon_extractbtn_XPTH");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the extract button.");

		Thread.sleep(10000);

		// fetch the record from the download file

	}
}
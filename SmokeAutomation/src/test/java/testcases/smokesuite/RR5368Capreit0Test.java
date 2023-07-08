package testcases.smokesuite;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5368Capreit0Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit0Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5368Capreit0Test", excel))) {

			throw new SkipException("Skipping the test " + "rR5368Capreit0Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// UPDATE THE PROPERTY TYPE - ADMIN USER

		System.out.println("******************** UPDATE THE PROPERTY TYPE - ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** UPDATE THE PROPERTY TYPE - ADMIN USER ********************");
		Reporter.log("******************** UPDATE THE PROPERTY TYPE - ADMIN USER ********************");
		log.info("******************** UPDATE THE PROPERTY TYPE - ADMIN USER ********************");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {
			// LOGIN WITH ADMIN USER

			System.out.println("******************** LOGIN WITH ADMIN USER ********************");
			test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
			Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
			log.info("******************** LOGIN WITH ADMIN USER ********************");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY

			updateCompany(data);

			// UPDATE THE PROPERTY TYPE

			System.out.println("******************** UPDATE THE PROPERTY TYPE ********************");
			test.log(LogStatus.INFO, "******************** UPDATE THE PROPERTY TYPE ********************");
			Reporter.log("******************** UPDATE THE PROPERTY TYPE ********************");
			log.info("******************** UPDATE THE PROPERTY TYPE ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the property information icon
				click("propertyinformationicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property information icon.");

				// click on the edit button
				click("propertyinformation_editbtn_CSS");
				System.out.println("Clicked on the edit button.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement typeField = driver
						.findElement(By.cssSelector(OR.getProperty("propertyinformation_typetxt_CSS")));
				js.executeScript("arguments[0].scrollIntoView(true);", typeField);
				js.executeScript("window.scrollBy(0,-400)");

				// enter the property type
				clear("propertyinformation_typetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("propertyinformation_typetxt_CSS", data.get("property_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property type.");

				// scroll down the screen
				WebElement savebtn = driver
						.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
				js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

				// click on the save button
				click("propertyinformation_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

	}

}

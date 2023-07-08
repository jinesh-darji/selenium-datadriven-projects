package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5595Morguard2Test", excel))) {

			throw new SkipException("Skipping the test " + "rR5595Morguard2Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
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

		} catch (Throwable t) {
			verificationFailed();
		}

		// RESET THE DESHBOARD FILTER

		System.out.println("******************** RESET THE DESHBOARD FILTER ********************");
		test.log(LogStatus.INFO, "******************** RESET THE DESHBOARD FILTER ********************");
		Reporter.log("******************** RESET THE DESHBOARD FILTER ********************");
		log.info("******************** RESET THE DESHBOARD FILTER ********************");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyinfo_dashboardfilterlbl_XPATH");

			// click on the dashboard filter option from the side menu
			click("propertyinfo_dashboardfilterlbl_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the dashboard filter option from the side menu.");

			// click on the statuses label

			try {
				boolean statuslabel = driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuslbl_XPATH")))
						.isDisplayed();
				if (statuslabel == true) {

					// click on the status label
					click("propertyinfo_dashboardfilterlbl_statuslbl_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the statuses label.");

				} else {

					// click on the statuses label
					click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the statuses label.");

				}
			} catch (Throwable t) {
				// click on the statuses label
				click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the statuses label.");
			}

			// wait for the element
			Thread.sleep(3000);

			// click on the checkbox of the active option

			try {
				boolean active = driver
						.findElement(
								By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_XPATH")))
						.isSelected();

				if (active == true) {
					System.out.println("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the checkbox of the active option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the active option.");

					System.out.println("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {
				// click on the checkbox of the active option
				click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the checkbox of the active option.");

				System.out.println("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				Reporter.log("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				log.info("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
			}

			// wait for the element
			Thread.sleep(3000);

			// click on the checkbox of the inactive option

			try {
				boolean inactive = driver
						.findElement(By
								.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_XPATH")))
						.isSelected();

				if (inactive == true) {
					System.out.println("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the checkbox of the inactive option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_unchecked_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the active option.");

					System.out.println("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {
				// click on the checkbox of the inactive option
				click("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_unchecked_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the checkbox of the active option.");

				System.out.println("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				Reporter.log("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				log.info("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
			}

			// wait for the element
			Thread.sleep(3000);

			// click on the close button
			click("propertyinfo_dashboardfilterlbl_statuseslbl_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO
		// THE NEW PROPERTY NUMBER

		System.out.println(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO THE NEW PROPERTY NUMBER ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO THE NEW PROPERTY NUMBER ********************");
		Reporter.log(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO THE NEW PROPERTY NUMBER ********************");
		log.info(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO THE NEW PROPERTY NUMBER ********************");

		// MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY
		// NUMBER TO THE NEW ACTIVE PROPERTY NUMBER

		System.out.println(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");
		Reporter.log(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");
		log.info(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_11"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

			// click on the save button
			click("propertyinformation_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1

		System.out.println(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");
		Reporter.log(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");
		log.info(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_XPATH", "Active", "The active status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the active radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active radio button.");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the source property field.");

			// enter the property in the search field
			clear("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH");
			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property in the search field.");

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of the confirmation model.");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of final the confirmation model.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement typeField = driver.findElement(By.xpath(OR.getProperty("propertyinfo_typelbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", typeField);
			js.executeScript("window.scrollBy(0,-400)");

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype1_XPATH", "Industrial Active to Active Two",
					"The Industrial Active to Active Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY
		// NUMBER TO THE NEW ACTIVE PROPERTY NUMBER

		System.out.println(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");
		Reporter.log(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");
		log.info(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER ********************");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH"))),
							"The active inactive is not displayed.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_22"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1

		System.out.println(
				"******************** MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");
		Reporter.log(
				"******************** MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");
		log.info(
				"******************** MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1 ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_XPATH", "Active", "The active status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the inactive radio button
			click("propertyinfo_mergebtn_inactiveradio_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inactive radio button.");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the source property field.");

			// enter the property in the search field
			clear("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH");
			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property in the search field.");

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of the confirmation model.");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of final the confirmation model.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement typeField = driver.findElement(By.xpath(OR.getProperty("propertyinfo_typelbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", typeField);
			js.executeScript("window.scrollBy(0,-400)");

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype2_XPATH", "Industrial Active to Inactive Two",
					"The Industrial Active to Inactive Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY
		// NUMBER TO THE NEW INACTIVE PROPERTY NUMBER

		System.out.println(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");
		Reporter.log(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");
		log.info(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH"))),
							"The active inactive is not displayed.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_33"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1

		System.out.println(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");
		Reporter.log(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");
		log.info(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_inactive_XPATH", "Inactive",
					"The inactive status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the inactive radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inactive radio button.");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the source property field.");

			// enter the property in the search field
			clear("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH");
			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property in the search field.");

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of the confirmation model.");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of final the confirmation model.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement typeField = driver.findElement(By.xpath(OR.getProperty("propertyinfo_typelbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", typeField);
			js.executeScript("window.scrollBy(0,-400)");

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype3_XPATH", "Industrial Inactive to Active Two",
					"The Industrial Inactive to Active Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY
		// NUMBER TO THE NEW INACTIVE PROPERTY NUMBER

		System.out.println(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");
		Reporter.log(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");
		log.info(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER ********************");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH"))),
							"The active inactive is not displayed.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH"))),
							"The active inactive is not displayed.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_44"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1

		System.out.println(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");
		Reporter.log(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");
		log.info(
				"******************** MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1 ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_inactive_XPATH", "Inactive",
					"The Inactive status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the inactive radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inactive radio button.");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the source property field.");

			// enter the property in the search field
			clear("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH");
			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property in the search field.");

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of the confirmation model.");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of final the confirmation model.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement typeField = driver.findElement(By.xpath(OR.getProperty("propertyinfo_typelbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", typeField);
			js.executeScript("window.scrollBy(0,-400)");

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype4_XPATH", "Industrial Inactive to Inactive Two",
					"The Industrial Inactive to Inactive Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION – TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER

		System.out.println(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER ********************");
		Reporter.log(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER ********************");
		log.info(
				"******************** MERGE FUNCTION – TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER ********************");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY

		System.out.println(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		Reporter.log(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");
		log.info(
				"******************** UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type_11"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE PROPERTY DETAILS

		System.out.println("******************** RESET THE PROPERTY DETAILS ********************");
		test.log(LogStatus.INFO, "******************** RESET THE PROPERTY DETAILS ********************");
		Reporter.log("******************** RESET THE PROPERTY DETAILS ********************");
		log.info("******************** RESET THE PROPERTY DETAILS ********************");

		// RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY

		System.out.println(
				"******************** RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY ********************");
		Reporter.log(
				"******************** RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY ********************");
		log.info("******************** RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");
			System.out.println("Clicked on the edit button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the property name
			clear("propertyinfo_mergebtn_propertynametxt_XPATH");
			type("propertyinfo_mergebtn_propertynametxt_XPATH", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement typeField = driver
					.findElement(By.cssSelector(OR.getProperty("propertyinformation_typetxt_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", typeField);
			js.executeScript("window.scrollBy(0,-400)");

			// enter the property type
			clear("propertyinformation_typetxt_CSS");
			type("propertyinformation_typetxt_CSS", data.get("property_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView(true);", savebtn);

			// click on the save button
			click("propertyinformation_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY

		System.out.println(
				"******************** RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY ********************");
		Reporter.log(
				"******************** RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY ********************");
		log.info("******************** RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH"))),
							"The active satus is not displayed.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the mark as active button.");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button of the confirmation.");

					System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				System.out.println("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the mark as active button.");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the ok button of the confirmation.");

				System.out.println("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

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
			type("propertyinformation_typetxt_CSS", data.get("property_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property type.");

			// scroll down the screen
			WebElement savebtn = driver.findElement(By.cssSelector(OR.getProperty("propertyinformation_savebtn_CSS")));
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY

		System.out
				.println("******************** MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY ********************");
		Reporter.log("******************** MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY ********************");
		log.info("******************** MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the property information
			click("propertyinformationicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property information.");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_XPATH", "Active", "The active status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the active radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active radio button.");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the source property field.");

			// enter the property in the search field
			clear("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH");
			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_1_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.xpath(OR.getProperty("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(OR.getProperty("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of the confirmation model.");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the merge button of final the confirmation model.");

			// verify error is displayed in the property 1 or not
			try {
				boolean errorMessage = driver
						.findElement(
								By.xpath(OR.getProperty("propertyinfo_mergebtn_sourcepropertytxt_errormessage_XPATH")))
						.isDisplayed();

				if (errorMessage == true) {
					System.out.println("AN ERROR MESSAGE IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "AN ERROR MESSAGE IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("AN ERROR MESSAGE IS DISPLAYED SUCCESSFULLY.");
					log.info("AN ERROR MESSAGE IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("AN ERROR MESSAGE IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "AN ERROR MESSAGE IS NOT DISPLAYED.");
					Reporter.log("AN ERROR MESSAGE IS NOT DISPLAYED.");
					log.info("AN ERROR MESSAGE IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("AN ERROR MESSAGE IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "AN ERROR MESSAGE IS NOT DISPLAYED.");
				Reporter.log("AN ERROR MESSAGE IS NOT DISPLAYED.");
				log.info("AN ERROR MESSAGE IS NOT DISPLAYED.");
			}

			// click on the cancel button
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SET THE DESHBOARD FILTER

		System.out.println("******************** SET THE DESHBOARD FILTER ********************");
		test.log(LogStatus.INFO, "******************** SET THE DESHBOARD FILTER ********************");
		Reporter.log("******************** SET THE DESHBOARD FILTER ********************");
		log.info("******************** SET THE DESHBOARD FILTER ********************");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyinfo_dashboardfilterlbl_XPATH");

			// click on the dashboard filter option from the side menu
			click("propertyinfo_dashboardfilterlbl_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the dashboard filter option from the side menu.");

			// click on the statuses label

			try {
				boolean statuslabel = driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuslbl_XPATH")))
						.isDisplayed();
				if (statuslabel == true) {

					// click on the status label
					click("propertyinfo_dashboardfilterlbl_statuslbl_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the statuses label.");

				} else {

					// click on the statuses label
					click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the statuses label.");

				}
			} catch (Throwable t) {
				// click on the statuses label
				click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the statuses label.");
			}

			// click on the checkbox of the active option

			try {
				boolean active1 = driver
						.findElement(
								By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_XPATH")))
						.isSelected();

				if (active1 == true) {
					System.out.println("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the checkbox of the active option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the active option.");

					System.out.println("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {
				// click on the checkbox of the active option
				click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the checkbox of the active option.");

				System.out.println("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				Reporter.log("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				log.info("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
			}

			// click on the checkbox of the inactive option

			try {
				boolean inactive1 = driver
						.findElement(By
								.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_XPATH")))
						.isSelected();

				if (inactive1 == true) {

					// click on the checkbox of the inactive option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the active option.");

					System.out.println("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
					Reporter.log("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
					log.info("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");

				} else {

					System.out.println("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
					Reporter.log("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
					log.info("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {

				System.out.println("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
				Reporter.log("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
				log.info("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
			}

			// click on the close button
			click("propertyinfo_dashboardfilterlbl_statuseslbl_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

	}
}

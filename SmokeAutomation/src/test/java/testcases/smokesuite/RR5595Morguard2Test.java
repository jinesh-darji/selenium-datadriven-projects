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

		execution(data, "rR5595Morguard2Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

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
		title("RESET THE DESHBOARD FILTER");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("propertyinfo_dashboardfilterlbl_XPATH");

			// click on the dashboard filter option from the side menu
			click("propertyinfo_dashboardfilterlbl_XPATH");

			// click on the statuses label

			try {
				boolean statuslabel = driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuslbl_XPATH")))
						.isDisplayed();
				if (statuslabel == true) {

					// click on the status label
					click("propertyinfo_dashboardfilterlbl_statuslbl_XPATH");

				} else {

					// click on the statuses label
					click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");

				}
			} catch (Throwable t) {
				// click on the statuses label
				click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");

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
					successMessage("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the checkbox of the active option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");

					successMessage("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {
				// click on the checkbox of the active option
				click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");

				successMessage("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
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
					successMessage("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the checkbox of the inactive option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_unchecked_XPATH");

					successMessage("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {
				// click on the checkbox of the inactive option
				click("propertyinfo_dashboardfilterlbl_statuseslbl_inactivebtn_unchecked_XPATH");

				successMessage("THE INACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
			}

			// wait for the element
			Thread.sleep(3000);

			// click on the close button
			click("propertyinfo_dashboardfilterlbl_statuseslbl_closebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO
		// THE NEW PROPERTY NUMBER
		title("MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD PROPERTY NUMBER TO THE NEW PROPERTY NUMBER");

		// MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY
		// NUMBER TO THE NEW ACTIVE PROPERTY NUMBER
		title("MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");

			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_1"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_11"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1
		title("MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_XPATH", "Active", "The active status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the active radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");

			// enter the property in the search field

			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_typelbl_XPATH");
			scrollByPixel(-400);

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype1_XPATH", "Industrial Active to Active Two",
					"The Industrial Active to Active Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY
		// NUMBER TO THE NEW ACTIVE PROPERTY NUMBER
		title("MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW ACTIVE PROPERTY NUMBER");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {

				successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_2"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_22"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {

			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1
		title("MERGE THE PEROPERTY FROM THE INACTIVE PROPERTY 2 TO ACTIVE PROPERTY 1");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_XPATH", "Active", "The active status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the inactive radio button
			click("propertyinfo_mergebtn_inactiveradio_XPATH");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");

			// enter the property in the search field

			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_typelbl_XPATH");
			scrollByPixel(-400);

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype2_XPATH", "Industrial Active to Inactive Two",
					"The Industrial Active to Inactive Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY
		// NUMBER TO THE NEW INACTIVE PROPERTY NUMBER
		title("MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD ACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_3"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_33"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {

			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1
		title("MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_inactive_XPATH", "Inactive",
					"The inactive status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the inactive radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");

			// enter the property in the search field

			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_typelbl_XPATH");
			scrollByPixel(-400);

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype3_XPATH", "Industrial Inactive to Active Two",
					"The Industrial Inactive to Active Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY
		// NUMBER TO THE NEW INACTIVE PROPERTY NUMBER
		title("MERGE FUNCTION � TRANSFER OVER INFORMATION FROM THE OLD INACTIVE PROPERTY NUMBER TO THE NEW INACTIVE PROPERTY NUMBER");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - INACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {
					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_4"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - INACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make inactive if not

			try {
				String status = (driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_inactive_XPATH")))
						.getText()).trim();

				if (status.equals("Inactive")) {

					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

					// click on the mark as inactive button
					click("propertyinfo_markasinactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT INACTION.");

				// click on the mark as inactive button
				click("propertyinfo_markasinactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE INACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_44"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {

			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1
		title("MERGE THE PEROPERTY FROM THE ACTIVE PROPERTY 2 TO INACTIVE PROPERTY 1");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_inactive_XPATH", "Inactive",
					"The Inactive status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the inactive radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");

			// enter the property in the search field

			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_2_number"));

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty2_XPATH");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// scroll down the screen
			scrollTillElement("propertyinfo_typelbl_XPATH");
			scrollByPixel(-400);

			// verify property 2 details are displayed in the property 1 or not
			switchVerification("propertyinfo_mergedpropertytype4_XPATH", "Industrial Inactive to Inactive Two",
					"The Industrial Inactive to Inactive Two property type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE FUNCTION � TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER
		title("MERGE FUNCTION � TRANSFER OVER INFORMATION IN THE SAME PROPERTY NUMBER");

		// UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE FIRST PROPERTY - ACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_1"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY
		title("UPDATE THE PROPERTY TYPE OF THE SECOND PROPERTY - ACTIVE PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				}

			} catch (Throwable t) {

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type_11"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE PROPERTY DETAILS
		title("RESET THE PROPERTY DETAILS");

		// RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY
		title("RESET THE PROPERTY TYPE AND STATUS OF THE FIRST PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");

				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// enter the property name

			type("propertyinfo_mergebtn_propertynametxt_XPATH", data.get("property_1"));

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY
		title("RESET THE PROPERTY TYPE AND STATUS OF THE SECOND PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2_number"));

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl2_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report property name is not displayed.");

			// verify status of the property and make active if not

			try {
				String status = (driver.findElement(By.xpath(OR.getProperty("propertyinfo_propertystatuslbl_XPATH")))
						.getText()).trim();

				if (status.equals("Active")) {

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

					// click on the mark as active button
					click("propertyinfo_markasactivebtn_XPATH");

					// wait for the element
					explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

					// click on the ok button of the confirmation
					click("propertyinfo_markasactive_okbtn_XPATH");

					successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED, SO MAKE IT ACTION.");

				// click on the mark as active button
				click("propertyinfo_markasactivebtn_XPATH");

				// wait for the element
				explicitWaitClickable("propertyinfo_markasactive_okbtn_XPATH");

				// click on the ok button of the confirmation
				click("propertyinfo_markasactive_okbtn_XPATH");

				successMessage("THE ACTIVE STATUS OF THE PROPERTY IS DISPLAYED SUCCESSFULLY.");
			}

			// click on the edit button
			click("propertyinformation_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("propertyinformation_typetxt_CSS");
			scrollByPixel(-400);

			// enter the property type

			type("propertyinformation_typetxt_CSS", data.get("property_type"));

			// scroll down the screen
			scrollTillElement("propertyinformation_savebtn_CSS");

			// click on the save button
			click("propertyinformation_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY
		title("MERGE THE PEROPERTY DETAILS IN THE SAME PROPERTY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.cssSelector(OR.getProperty("envreports_propertylist_filtertxt_CSS")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the property information
			click("propertyinformationicon_CSS");

			// verify name of the property
			switchVerification("propertyinfo_propertynamelbl_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property name is not displayed.");

			// verify the status of the property
			switchVerification("propertyinfo_propertystatuslbl_XPATH", "Active", "The active status is not displayed.");

			// click on the merge button
			click("propertyinfo_mergebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the active radio button
			click("propertyinfo_mergebtn_activeradio_XPATH");

			// click on the source property field
			click("propertyinfo_mergebtn_sourcepropertytxt_XPATH");

			// enter the property in the search field

			type("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH", data.get("property_1_number"));

			// remove the decimal characters from the search field
			driver.findElement(By.xpath(OR.getProperty("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(OR.getProperty("propertyinfo_mergebtn_sourcepropertytxt_searchusertxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);

			// click on the searched property
			click("propertyinfo_mergebtn_sourcepropertytxt_searchedproperty1_XPATH");

			// click on the merge button of the confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn_XPATH");

			// wait for the element
			explicitWaitClickable("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// click on the merge button of the final confirmation model
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_XPATH");

			// verify error is displayed in the property 1 or not
			try {
				boolean errorMessage = driver
						.findElement(
								By.xpath(OR.getProperty("propertyinfo_mergebtn_sourcepropertytxt_errormessage_XPATH")))
						.isDisplayed();

				if (errorMessage == true) {
					successMessage("AN ERROR MESSAGE IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("AN ERROR MESSAGE IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("AN ERROR MESSAGE IS NOT DISPLAYED.");
			}

			// click on the cancel button
			click("propertyinfo_mergebtn_sourcepropertytxt_confirmationmergebtn1_cancelbtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SET THE DESHBOARD FILTER
		title("SET THE DESHBOARD FILTER");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("propertyinfo_dashboardfilterlbl_XPATH");

			// click on the dashboard filter option from the side menu
			click("propertyinfo_dashboardfilterlbl_XPATH");

			// click on the statuses label

			try {
				boolean statuslabel = driver
						.findElement(By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuslbl_XPATH")))
						.isDisplayed();
				if (statuslabel == true) {

					// click on the status label
					click("propertyinfo_dashboardfilterlbl_statuslbl_XPATH");

				} else {

					// click on the statuses label
					click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");

				}
			} catch (Throwable t) {
				// click on the statuses label
				click("propertyinfo_dashboardfilterlbl_statuseslbl_XPATH");

			}

			// click on the checkbox of the active option

			try {
				boolean active1 = driver
						.findElement(
								By.xpath(OR.getProperty("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_XPATH")))
						.isSelected();

				if (active1 == true) {
					successMessage("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the checkbox of the active option
					click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");

					successMessage("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
				}
			} catch (Throwable t) {
				// click on the checkbox of the active option
				click("propertyinfo_dashboardfilterlbl_statuseslbl_activebtn_unchecked_XPATH");

				successMessage("THE ACTIVE CHECKBOX IS DISPLAYED SELECTED AS EXPECTED.");
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

					successMessage("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");

				} else {
					successMessage("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");

				}
			} catch (Throwable t) {

				successMessage("THE INACTIVE CHECKBOX IS DISPLAYED UNSELECTED AS EXPECTED.");
			}

			// click on the close button
			click("propertyinfo_dashboardfilterlbl_statuseslbl_closebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
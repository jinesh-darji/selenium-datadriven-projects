package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR4975PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4975PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4975PropertyProjectTest");

		// THE UNDERTAKING PROJECT STATUS AND SHOULD GET REFLECTED BELOW THE LENDER
		// FIELD.
		title("THE UNDERTAKING PROJECT STATUS AND SHOULD GET REFLECTED BELOW THE LENDER FIELD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD MORTGAGE UNDERTAKINGS
		title("ADD MORTGAGE UNDERTAKINGS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD RECORD - MORTGAGE UNDERTAKINGS
		title("ADD RECORD - MORTGAGE UNDERTAKINGS");

		try {
			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount1 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount1_XPATH"))).isDisplayed();

			if ((history1 && historycount1) == true) {
				successMessage("The history count is displayed correct after create the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after create the mortgage undertaking.");
			}

			// verify the in-progress button is displayed or not
			String text1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText1 = text1.trim();

			if (finalText1.equalsIgnoreCase("Mark As In-Progress")) {
				successMessage("The in-progress button is displayed successfully.");
			} else {
				verificationFailedMessage("The in-progress button is not displayed.");
			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the Mortgage Undertakings is added or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_opentablestatus_XPATH", "Open", "The Open Status is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS
		title("UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS");

		try {

			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history11 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount11 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount1_XPATH"))).isDisplayed();

			if ((history11 && historycount11) == true) {
				successMessage("The history count is displayed correct after create the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after create the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text11 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText11 = text11.trim();

			if (finalText11.equalsIgnoreCase("Mark As In-Progress")) {
				successMessage("The in-progress button is displayed successfully.");
			} else {
				verificationFailedMessage("The in-progress button is not displayed.");

			}

			// click on the in progress button
			click("propertyproject_mu_inprogressbtn_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history2 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount2 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount2_XPATH"))).isDisplayed();

			if ((history2 && historycount2) == true) {
				successMessage(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after the status of the mortgage undertaking.");

			}

			// verify the open button is displayed or not
			String text2 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText2 = text2.trim();

			if (finalText2.equalsIgnoreCase("Mark As Open")) {
				successMessage("The Open button is displayed successfully.");
			} else {
				verificationFailedMessage("The Open button is not displayed.");

			}

			// verify the complete button is displayed or not
			String text3 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText3 = text3.trim();

			if (finalText3.equalsIgnoreCase("Mark As Complete")) {
				successMessage("The Complete button is displayed successfully.");
			} else {
				verificationFailedMessage("The Complete button is not displayed.");
			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the Mortgage Undertakings is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the mortgage undertaking
			switchVerification("propertyproject_mu_inprogresstablestatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO OPEN
		title("UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO OPEN");

		try {

			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history22 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount22 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount2_XPATH"))).isDisplayed();

			if ((history22 && historycount22) == true) {
				successMessage(
						"The history count is displayed correct after update the status the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after update the status the mortgage undertaking.");
			}

			// verify the open button is displayed or not
			String text22 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText22 = text22.trim();

			if (finalText22.equalsIgnoreCase("Mark As Open")) {
				successMessage("The Open button is displayed successfully.");
			} else {
				verificationFailedMessage("The Open button is not displayed.");

			}

			// verify the complete button is displayed or not
			String text33 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText33 = text33.trim();

			if (finalText33.equalsIgnoreCase("Mark As Complete")) {
				successMessage("The Complete button is displayed successfully.");
			} else {
				verificationFailedMessage("The Complete button is not displayed.");

			}

			// click on the open button
			click("propertyproject_mu_openbtn_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history3 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount3 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount3_XPATH"))).isDisplayed();

			if ((history3 && historycount3) == true) {
				successMessage(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after the status of the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text4 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText4 = text4.trim();

			if (finalText4.equalsIgnoreCase("Mark As In-Progress")) {
				successMessage("The in-progress button is displayed successfully.");
			} else {
				verificationFailedMessage("The in-progress button is not displayed.");

			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the Mortgage Undertakings is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the mortgage undertaking
			switchVerification("propertyproject_mu_opentablestatus_XPATH", "Open", "The Open Status is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS
		title("UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS");

		try {
			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history33 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount33 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount3_XPATH"))).isDisplayed();

			if ((history33 && historycount33) == true) {
				successMessage(
						"The history count is displayed correct after update the status the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after update the status the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text44 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText44 = text44.trim();

			if (finalText44.equalsIgnoreCase("Mark As In-Progress")) {
				successMessage("The in-progress button is displayed successfully.");
			} else {
				verificationFailedMessage("The in-progress button is not displayed.");
			}

			// click on the in-progress button
			click("propertyproject_mu_inprogressbtn_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history4 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount4 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount4_XPATH"))).isDisplayed();

			if ((history4 && historycount4) == true) {
				successMessage(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after the status of the mortgage undertaking.");
			}

			// verify the open button is displayed or not
			String text5 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText5 = text5.trim();

			if (finalText5.equalsIgnoreCase("Mark As Open")) {
				successMessage("The Open button is displayed successfully.");
			} else {
				verificationFailedMessage("The Open button is not displayed.");
			}

			// verify the complete button is displayed or not
			String text6 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText6 = text6.trim();

			if (finalText6.equalsIgnoreCase("Mark As Complete")) {
				successMessage("The Complete button is displayed successfully.");
			} else {
				verificationFailedMessage("The Complete button is not displayed.");
			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the Mortgage Undertakings is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the mortgage undertaking
			switchVerification("propertyproject_mu_inprogresstablestatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO COMPLETE
		title("UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO COMPLETE");

		try {

			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history44 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount44 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount4_XPATH"))).isDisplayed();

			if ((history44 && historycount44) == true) {
				successMessage(
						"The history count is displayed correct after update the status the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after update the status the mortgage undertaking.");
			}

			// verify the open button is displayed or not
			String text55 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText55 = text55.trim();

			if (finalText55.equalsIgnoreCase("Mark As Open")) {
				successMessage("The Open button is displayed successfully.");
			} else {
				verificationFailedMessage("The Open button is not displayed.");
			}

			// verify the complete button is displayed or not
			String text66 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText66 = text66.trim();

			if (finalText66.equalsIgnoreCase("Mark As Complete")) {
				successMessage("The Complete button is displayed successfully.");
			} else {
				verificationFailedMessage("The Complete button is not displayed.");
			}

			// click on the complete button
			click("propertyproject_mu_completebtn_XPATH");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_completedstatus_XPATH", "Completed",
					"The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history5 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount5 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount5_XPATH"))).isDisplayed();

			if ((history5 && historycount5) == true) {
				successMessage(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				verificationFailedMessage(
						"The history count is not displayed correct after the status of the mortgage undertaking.");
			}

			// verify the in-progress button is displayed or not
			String text7 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText7 = text7.trim();

			if (finalText7.equalsIgnoreCase("Mark As In-Progress")) {
				successMessage("The in-progress button is displayed successfully.");
			} else {
				verificationFailedMessage("The in-progress button is not displayed.");
			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the Mortgage Undertakings is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the mortgage undertaking
			switchVerification("propertyproject_mu_completedtablestatus_XPATH", "Completed",
					"The Completed Status is not displayed.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE MORTGAGE UNDERTAKINGS
		title("DELETE THE MORTGAGE UNDERTAKINGS");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links2 = driver.findElements(By.xpath("//tr"));
			int count2 = links2.size();
			consoleMessage("Number of links are:" + count2);

			for (int i = 0; i < count2 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not
			try {

				String str = driver
						.findElement(
								By.xpath(OR.getProperty("propertyproject_mu_addedmortgageundertakingsstatus_XPATH")))
						.getText();

				if (str.equals("UNDERTAKINGSTATUS2021")) {
					verificationFailedMessage("The mortgage undertaking is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The mortgage undertaking is deleted successfully.");
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
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

		System.out.println("THE UNDERTAKING PROJECT STATUS AND SHOULD GET REFLECTED BELOW THE LENDER FIELD.");
		test.log(LogStatus.INFO, "THE UNDERTAKING PROJECT STATUS AND SHOULD GET REFLECTED BELOW THE LENDER FIELD.");
		Reporter.log("THE UNDERTAKING PROJECT STATUS AND SHOULD GET REFLECTED BELOW THE LENDER FIELD.");
		log.info("THE UNDERTAKING PROJECT STATUS AND SHOULD GET REFLECTED BELOW THE LENDER FIELD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD MORTGAGE UNDERTAKINGS

		System.out.println("**************** ADD MORTGAGE UNDERTAKINGS ****************");
		test.log(LogStatus.INFO, "**************** ADD MORTGAGE UNDERTAKINGS ****************");
		Reporter.log("**************** ADD MORTGAGE UNDERTAKINGS ****************");
		log.info("**************** ADD MORTGAGE UNDERTAKINGS ****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");
				System.out.println("Deleted the all the Mortgage Undertakings");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}
		// ADD RECORD - MORTGAGE UNDERTAKINGS

		System.out.println("**************** CREATE NEW MORTGAGE UNDERTAKINGS ****************");
		test.log(LogStatus.INFO, "**************** CREATE NEW MORTGAGE UNDERTAKINGS ****************");
		Reporter.log("**************** CREATE NEW MORTGAGE UNDERTAKINGS ****************");
		log.info("**************** CREATE NEW MORTGAGE UNDERTAKINGS ****************");

		try {
			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the lender.");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount1 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount1_XPATH"))).isDisplayed();

			if ((history1 && historycount1) == true) {
				System.out.println("The history count is displayed correct after create the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after create the mortgage undertaking.");
				Reporter.log("The history count is displayed correct after create the mortgage undertaking.");
				log.info("The history count is displayed correct after create the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "The history count is not displayed correct after create the mortgage undertaking. : "
								+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after create the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The history count is not displayed correct after create the mortgage undertaking.");
				log.info("The history count is not displayed correct after create the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText1 = text1.trim();

			if (finalText1.equalsIgnoreCase("Mark As In-Progress")) {
				System.out.println("The in-progress button is displayed successfully.");
				test.log(LogStatus.INFO, "The in-progress button is displayed successfully.");
				Reporter.log("The in-progress button is displayed successfully.");
				log.info("The in-progress button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The in-progress button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The in-progress button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The in-progress button is not displayed.");
				log.info("The in-progress button is not displayed.");

			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verification of the Mortgage Undertakings is added or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_opentablestatus_XPATH", "Open", "The Open Status is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS

		System.out.println(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");
		test.log(LogStatus.INFO,
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");
		Reporter.log(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");
		log.info(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");

		try {

			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the mortgage undertaking.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history11 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount11 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount1_XPATH"))).isDisplayed();

			if ((history11 && historycount11) == true) {
				System.out.println("The history count is displayed correct after create the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after create the mortgage undertaking.");
				Reporter.log("The history count is displayed correct after create the mortgage undertaking.");
				log.info("The history count is displayed correct after create the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "The history count is not displayed correct after create the mortgage undertaking. : "
								+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after create the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The history count is not displayed correct after create the mortgage undertaking.");
				log.info("The history count is not displayed correct after create the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text11 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText11 = text11.trim();

			if (finalText11.equalsIgnoreCase("Mark As In-Progress")) {
				System.out.println("The in-progress button is displayed successfully.");
				test.log(LogStatus.INFO, "The in-progress button is displayed successfully.");
				Reporter.log("The in-progress button is displayed successfully.");
				log.info("The in-progress button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The in-progress button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The in-progress button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The in-progress button is not displayed.");
				log.info("The in-progress button is not displayed.");

			}

			// click on the in progress button
			click("propertyproject_mu_inprogressbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the in progress button.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history2 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount2 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount2_XPATH"))).isDisplayed();

			if ((history2 && historycount2) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after the status of the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after the status of the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct the status of create the mortgage undertaking.");
				log.info("The history count is not displayed correct after the status of the mortgage undertaking.");

			}

			// verify the open button is displayed or not
			String text2 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText2 = text2.trim();

			if (finalText2.equalsIgnoreCase("Mark As Open")) {
				System.out.println("The Open button is displayed successfully.");
				test.log(LogStatus.INFO, "The Open button is displayed successfully.");
				Reporter.log("The Open button is displayed successfully.");
				log.info("The Open button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Open button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Open button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Open button is not displayed.");
				log.info("The Open button is not displayed.");

			}

			// verify the complete button is displayed or not
			String text3 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText3 = text3.trim();

			if (finalText3.equalsIgnoreCase("Mark As Complete")) {
				System.out.println("The Complete button is displayed successfully.");
				test.log(LogStatus.INFO, "The Complete button is displayed successfully.");
				Reporter.log("The Complete button is displayed successfully.");
				log.info("The Complete button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Complete button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Complete button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Complete button is not displayed.");
				log.info("The Complete button is not displayed.");

			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		System.out.println(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO OPEN ****************");
		test.log(LogStatus.INFO,
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO OPEN ****************");
		Reporter.log(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO OPEN ****************");
		log.info(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO OPEN ****************");

		try {

			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the mortgage undertaking.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history22 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount22 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount2_XPATH"))).isDisplayed();

			if ((history22 && historycount22) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after update the status the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after update the status the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct after update the status the mortgage undertaking.");
				log.info(
						"The history count is not displayed correct after update the status the mortgage undertaking.");

			}

			// verify the open button is displayed or not
			String text22 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText22 = text22.trim();

			if (finalText22.equalsIgnoreCase("Mark As Open")) {
				System.out.println("The Open button is displayed successfully.");
				test.log(LogStatus.INFO, "The Open button is displayed successfully.");
				Reporter.log("The Open button is displayed successfully.");
				log.info("The Open button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Open button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Open button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Open button is not displayed.");
				log.info("The Open button is not displayed.");

			}

			// verify the complete button is displayed or not
			String text33 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText33 = text33.trim();

			if (finalText33.equalsIgnoreCase("Mark As Complete")) {
				System.out.println("The Complete button is displayed successfully.");
				test.log(LogStatus.INFO, "The Complete button is displayed successfully.");
				Reporter.log("The Complete button is displayed successfully.");
				log.info("The Complete button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Complete button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Complete button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Complete button is not displayed.");
				log.info("The Complete button is not displayed.");

			}

			// click on the open button
			click("propertyproject_mu_openbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the open button.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history3 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount3 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount3_XPATH"))).isDisplayed();

			if ((history3 && historycount3) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after the status of the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after the status of the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct the status of create the mortgage undertaking.");
				log.info("The history count is not displayed correct after the status of the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text4 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText4 = text4.trim();

			if (finalText4.equalsIgnoreCase("Mark As In-Progress")) {
				System.out.println("The in-progress button is displayed successfully.");
				test.log(LogStatus.INFO, "The in-progress button is displayed successfully.");
				Reporter.log("The in-progress button is displayed successfully.");
				log.info("The in-progress button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The in-progress button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The in-progress button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The in-progress button is not displayed.");
				log.info("The in-progress button is not displayed.");

			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verification of the Mortgage Undertakings is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the mortgage undertaking
			switchVerification("propertyproject_mu_opentablestatus_XPATH", "Open", "The Open Status is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS

		System.out.println(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");
		test.log(LogStatus.INFO,
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");
		Reporter.log(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");
		log.info(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM OPEN TO IN PROGRESS ****************");

		try {
			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the mortgage undertaking.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_openstatus_XPATH", "Open", "The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history33 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount33 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount3_XPATH"))).isDisplayed();

			if ((history33 && historycount33) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after update the status the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after update the status the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct after update the status the mortgage undertaking.");
				log.info(
						"The history count is not displayed correct after update the status the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text44 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText44 = text44.trim();

			if (finalText44.equalsIgnoreCase("Mark As In-Progress")) {
				System.out.println("The in-progress button is displayed successfully.");
				test.log(LogStatus.INFO, "The in-progress button is displayed successfully.");
				Reporter.log("The in-progress button is displayed successfully.");
				log.info("The in-progress button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The in-progress button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The in-progress button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The in-progress button is not displayed.");
				log.info("The in-progress button is not displayed.");

			}

			// click on the in-progress button
			click("propertyproject_mu_inprogressbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the in-progress button.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history4 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount4 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount4_XPATH"))).isDisplayed();

			if ((history4 && historycount4) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after the status of the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after the status of the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct the status of create the mortgage undertaking.");
				log.info("The history count is not displayed correct after the status of the mortgage undertaking.");

			}

			// verify the open button is displayed or not
			String text5 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText5 = text5.trim();

			if (finalText5.equalsIgnoreCase("Mark As Open")) {
				System.out.println("The Open button is displayed successfully.");
				test.log(LogStatus.INFO, "The Open button is displayed successfully.");
				Reporter.log("The Open button is displayed successfully.");
				log.info("The Open button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Open button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Open button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Open button is not displayed.");
				log.info("The Open button is not displayed.");

			}

			// verify the complete button is displayed or not
			String text6 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText6 = text6.trim();

			if (finalText6.equalsIgnoreCase("Mark As Complete")) {
				System.out.println("The Complete button is displayed successfully.");
				test.log(LogStatus.INFO, "The Complete button is displayed successfully.");
				Reporter.log("The Complete button is displayed successfully.");
				log.info("The Complete button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Complete button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Complete button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Complete button is not displayed.");
				log.info("The Complete button is not displayed.");

			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		System.out.println(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO COMPLETE ****************");
		test.log(LogStatus.INFO,
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO COMPLETE ****************");
		Reporter.log(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO COMPLETE ****************");
		log.info(
				"**************** UPDATE THE STATUS OF THE MORTGAGE UNDERTAKING FROM IN PROGRESS TO COMPLETE ****************");

		try {

			// click on the mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakingsstatus_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the mortgage undertaking.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history44 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount44 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount4_XPATH"))).isDisplayed();

			if ((history44 && historycount44) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after update the status the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after update the status the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct after update the status the mortgage undertaking.");
				log.info(
						"The history count is not displayed correct after update the status the mortgage undertaking.");

			}

			// verify the open button is displayed or not
			String text55 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_openbtn_XPATH"))).getText();
			String finalText55 = text55.trim();

			if (finalText55.equalsIgnoreCase("Mark As Open")) {
				System.out.println("The Open button is displayed successfully.");
				test.log(LogStatus.INFO, "The Open button is displayed successfully.");
				Reporter.log("The Open button is displayed successfully.");
				log.info("The Open button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Open button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Open button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Open button is not displayed.");
				log.info("The Open button is not displayed.");

			}

			// verify the complete button is displayed or not
			String text66 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_completebtn_XPATH")))
					.getText();
			String finalText66 = text66.trim();

			if (finalText66.equalsIgnoreCase("Mark As Complete")) {
				System.out.println("The Complete button is displayed successfully.");
				test.log(LogStatus.INFO, "The Complete button is displayed successfully.");
				Reporter.log("The Complete button is displayed successfully.");
				log.info("The Complete button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Complete button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Complete button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Complete button is not displayed.");
				log.info("The Complete button is not displayed.");

			}

			// click on the complete button
			click("propertyproject_mu_completebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the complete button.");

			// verify status of the newly created mortgage undertaking
			switchVerification("propertyproject_mu_completedstatus_XPATH", "Completed",
					"The Open Status is not displayed.");

			// verify history count is displayed correct or not
			boolean history5 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_historytab_XPATH")))
					.isDisplayed();
			boolean historycount5 = driver
					.findElement(By.xpath(OR.getProperty("propertyproject_mu_historycount5_XPATH"))).isDisplayed();

			if ((history5 && historycount5) == true) {
				System.out.println(
						"The history count is displayed correct after update the status the mortgage undertaking.");
				test.log(LogStatus.INFO,
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				Reporter.log(
						"The history count is displayed correct after update the status of the mortgage undertaking.");
				log.info("The history count is displayed correct after update the status of the mortgage undertaking.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "The history count is not displayed correct after the status of the mortgage undertaking. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The history count is not displayed correct after the status of the mortgage undertaking. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The history count is not displayed correct the status of create the mortgage undertaking.");
				log.info("The history count is not displayed correct after the status of the mortgage undertaking.");

			}

			// verify the in-progress button is displayed or not
			String text7 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_inprogressbtn_XPATH")))
					.getText();
			String finalText7 = text7.trim();

			if (finalText7.equalsIgnoreCase("Mark As In-Progress")) {
				System.out.println("The in-progress button is displayed successfully.");
				test.log(LogStatus.INFO, "The in-progress button is displayed successfully.");
				Reporter.log("The in-progress button is displayed successfully.");
				log.info("The in-progress button is displayed successfully.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The in-progress button is not displayed. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The in-progress button is not displayed. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The in-progress button is not displayed.");
				log.info("The in-progress button is not displayed.");

			}

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verification of the Mortgage Undertakings is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakingsstatus_XPATH", "UNDERTAKINGSTATUS2021",
					"Mortgage Undertakings is not displayed successfully.");

			// verify status of the mortgage undertaking
			switchVerification("propertyproject_mu_completedtablestatus_XPATH", "Completed",
					"The Completed Status is not displayed.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE MORTGAGE UNDERTAKINGS

		System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS ****************");
		test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS ****************");
		Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS ****************");
		log.info("**************** DELETE MORTGAGE UNDERTAKINGS ****************");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links2 = driver.findElements(By.xpath("//tr"));
			int count2 = links2.size();
			System.out.println("Number of links are:" + count2);

			for (int i = 0; i < count2 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");
				System.out.println("Deleted the all the Mortgage Undertakings");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not

			try {

				String str = driver
						.findElement(
								By.xpath(OR.getProperty("propertyproject_mu_addedmortgageundertakingsstatus_XPATH")))
						.getText();

				if (str.equals("UNDERTAKINGSTATUS2021")) {

					Assert.assertTrue(
							isElementPresent(By
									.xpath(OR.getProperty("propertyproject_mu_addedmortgageundertakingsstatus_XPATH"))),
							"The UNDERTAKINGSTATUS2021 is displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The mortgage undertaking is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The mortgage undertaking is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The mortgage undertaking is not deleted.");
					log.info("The mortgage undertaking is not deleted.");

				}
			} catch (Throwable t) {

				System.out.println("The mortgage undertaking is deleted successfully.");
				test.log(LogStatus.INFO, "The mortgage undertaking is deleted successfully.");
				Reporter.log("The mortgage undertaking is deleted successfully.");
				log.info("The mortgage undertaking is deleted successfully.");
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
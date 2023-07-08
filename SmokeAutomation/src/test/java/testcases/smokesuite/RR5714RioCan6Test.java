package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5714RioCan6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5714RioCan6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5714RioCan6Test", excel))) {

			throw new SkipException("Skipping the test " + "rR5714RioCan6Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT
		// SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT

		System.out.println(
				"******************** CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT ********************");
		Reporter.log(
				"******************** CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT ********************");
		log.info(
				"******************** CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT ********************");

		Helper helper = new Helper();

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK
		// MANAGEMENT - ADMIN USER

		System.out.println(
				"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - ADMIN USER ********************");
		log.info(
				"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - ADMIN USER ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// verify insurance policy section is displayed or not
			switchVerification("riskmanagement_propertysummary_insurancepolicysection_XPATH", "Insurance Policy",
					"The Insurance Policy section is not displayed.");

			// verify claims section is displayed or not
			switchVerification("riskmanagement_propertysummary_claimssection_XPATH", "Claims",
					"The Claims section is not displayed.");

			// click on the insurance policy title
			click("riskmanagement_propertysummary_insurancepolicysection_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance policy title.");

			// verify insurance policy section is displayed or not
			switchVerification("riskmanagement_propertysummary_insurancepolicysection_insurancepolicytitle_XPATH",
					"Insurance Policies", "The Insurance Policies screen is not displayed.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// click on the claims title
			click("riskmanagement_propertysummary_claimssection_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the claims title.");

			// verify insurance policy section is displayed or not
			switchVerification("riskmanagement_propertysummary_claimssection_claimstitle_XPATH", "Insurance Claims",
					"The Insurance Claims screen is not displayed.");

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

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

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

			// Enter the username
			type("usernametxt_CSS", data.get("username"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));
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

			// VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK
			// MANAGEMENT - PROPERTY MANAGER USER

			System.out.println(
					"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - PROPERTY MANAGER USER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - PROPERTY MANAGER USER ********************");
			Reporter.log(
					"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - PROPERTY MANAGER USER ********************");
			log.info(
					"******************** VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - PROPERTY MANAGER USER ********************");

			try {

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the risk management icon from the property list page
				click("riskmanagementicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the risk management icon of the Property.");

				// verify insurance policy section is displayed or not
				try {

					String insuranceTitle = (driver
							.findElement(By.xpath(
									OR.getProperty("riskmanagement_propertysummary_insurancepolicysection_XPATH")))
							.getText()).trim();

					if (insuranceTitle.equals("Insurance Policy")) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The  Insurance Policy is displayed without permission : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The  Insurance Policy is displayed without permission : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Insurance Policy is displayed without permission.");
						log.info("The Insurance Policy is displayed without permission.");

					}
				} catch (Throwable t) {
					System.out.println("The Insurance Policy is not displayed as expected.");
					test.log(LogStatus.INFO, "The Insurance Policy is not displayed as expected.");
					Reporter.log("The Insurance Policy is not displayed as expected.");
					log.info("The Insurance Policy is not displayed as expected.");
				}

				// verify claims section is displayed or not
				try {

					String claimsTitle = (driver
							.findElement(By.xpath(OR.getProperty("riskmanagement_propertysummary_claimssection_XPATH")))
							.getText()).trim();

					if (claimsTitle.equals("Claims")) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The  Claims is displayed without permission : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Claims is displayed without permission : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Claims is displayed without permission.");
						log.info("The Claims is displayed without permission.");

					}
				} catch (Throwable t) {
					System.out.println("The Claims is not displayed as expected.");
					test.log(LogStatus.INFO, "The Claims is not displayed as expected.");
					Reporter.log("The Claims is not displayed as expected.");
					log.info("The Claims is not displayed as expected.");
				}

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

			// wait for the 5 seconds
			Thread.sleep(5000);

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
			helper.questionnaireNotDisplayLogout(data);
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

	}
}

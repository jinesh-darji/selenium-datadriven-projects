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

		execution(data, "rR5714RioCan6Test");

		// CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT
		// SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT
		title("CLAIMS CHART AND POLICY DETAILS SHOULD BE RELIABLE AND ON CLICK OF CHART IT SHOULD OPEN THE CORRESPONDING CLAIM/POLICY REPORT");

		Helper helper = new Helper();

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK
		// MANAGEMENT - ADMIN USER
		title("VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - ADMIN USER");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// verify insurance policy section is displayed or not
			switchVerification("riskmanagement_propertysummary_insurancepolicysection_XPATH", "Insurance Policy",
					"The Insurance Policy section is not displayed.");

			// verify claims section is displayed or not
			switchVerification("riskmanagement_propertysummary_claimssection_XPATH", "Claims",
					"The Claims section is not displayed.");

			// click on the insurance policy title
			click("riskmanagement_propertysummary_insurancepolicysection_XPATH");

			// verify insurance policy section is displayed or not
			switchVerification("riskmanagement_propertysummary_insurancepolicysection_insurancepolicytitle_XPATH",
					"Insurance Policies", "The Insurance Policies screen is not displayed.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// click on the claims title
			click("riskmanagement_propertysummary_claimssection_XPATH");

			// verify insurance policy section is displayed or not
			switchVerification("riskmanagement_propertysummary_claimssection_claimstitle_XPATH", "Insurance Claims",
					"The Insurance Claims screen is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

			// VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK
			// MANAGEMENT - PROPERTY MANAGER USER
			title("VERIFY INSURANCE POLICY AND CLAIMS SECTION IN PROPERTY SUMMARY SCREEN OF RISK MANAGEMENT - PROPERTY MANAGER USER");

			try {

				// enter the property name in the search field

				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

				// click on the risk management icon from the property list page
				click("riskmanagementicon_CSS");

				// verify insurance policy section is displayed or not
				try {

					String insuranceTitle = (driver
							.findElement(By.xpath(
									OR.getProperty("riskmanagement_propertysummary_insurancepolicysection_XPATH")))
							.getText()).trim();

					if (insuranceTitle.equals("Insurance Policy")) {

						verificationFailedMessage("The  Insurance Policy is displayed without permission");

					}
				} catch (Throwable t) {
					successMessage("The Insurance Policy is not displayed as expected.");
				}

				// verify claims section is displayed or not
				try {

					String claimsTitle = (driver
							.findElement(By.xpath(OR.getProperty("riskmanagement_propertysummary_claimssection_XPATH")))
							.getText()).trim();

					if (claimsTitle.equals("Claims")) {

						verificationFailedMessage("The  Claims is displayed without permission");
					}
				} catch (Throwable t) {
					successMessage("The Claims is not displayed as expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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
			helper.questionnaireNotDisplayLogout(data);
		}

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
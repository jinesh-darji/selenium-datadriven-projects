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

		execution(data, "rR5368Capreit0Test");

		// UPDATE THE PROPERTY TYPE - ADMIN USER
		title("UPDATE THE PROPERTY TYPE - ADMIN USER");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {
			// LOGIN WITH ADMIN USER
			title("LOGIN WITH ADMIN USER");

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

			// UPDATE THE PROPERTY TYPE
			title("UPDATE THE PROPERTY TYPE");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property information icon
				click("propertyinformationicon_CSS");

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

		} catch (Throwable t) {
			verificationFailed();
		}
	}
}
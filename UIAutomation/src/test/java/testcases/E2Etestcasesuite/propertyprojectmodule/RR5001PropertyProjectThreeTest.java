package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5001PropertyProjectThreeTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5001PropertyProjectThreeTest(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		execution(data, "rR5001PropertyProjectThreeTest");

		// MUNICIPAL ORDERS COUNTS ON A PROPERTY LEVEL.
		title("MUNICIPAL ORDERS COUNTS ON A PROPERTY LEVEL.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE MUNICIPAL ORDERSS FROM THE PROPERTY ONE
		title("DELETE MUNICIPAL ORDERSS FROM THE PROPERTY ONE");

		try {
			// enter the property one name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// CREATE THE RAMDOM MUNICIPAL ORDERS IN THE PROPERTY ONE
			title("CREATE THE RAMDOM MUNICIPAL ORDERS IN THE PROPERTY ONE");

			// ADD RECORD - MUNICIPAL ORDERSS
			title("ADD RECORD - MUNICIPAL ORDERSS");

			Random random = new Random();
			int mocount1 = random.nextInt(5 - 1) + 1;
			consoleMessage("Municipal Orders Count in Property One: " + mocount1);

			for (int i = 1; i <= mocount1; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				String projectreference1 = RandomStringUtils.randomAlphabetic(8);

				// enter the project reference
				type("propertyproject_mo_projectnumbertxt_CSS", projectreference1);

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY MUNICIPAL ORDERS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE
			title("VERIFY MUNICIPAL ORDERS COUNT ON PROPERTY LEVEL FOR THE PROPERTY ONE");

			// enter the property one name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			try {
				// wait for the element
				explicitWaitClickable("propertyproject_mo_countpropertylevel_XPATH");

				String actualCount = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mo_countpropertylevel_XPATH"))).getText();

				String expectedCount = Integer.toString(mocount1);

				consoleMessage("The municipal orders actual count is : " + actualCount + " and expected count is : "
						+ expectedCount);

				if (actualCount.equals(expectedCount)) {
					successMessage("The municipal orders counts are displayed correct in the property one.");
				} else {
					verificationFailedMessage(
							"The municipal orders counts are not displayed correct in the property one.");
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// DELETE MUNICIPAL ORDERSS FROM THE PROPERTY TWO
		title("DELETE MUNICIPAL ORDERSS FROM THE PROPERTY TWO");

		try {
			// enter the property one name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links2 = driver.findElements(By.xpath("//tr"));
			int count2 = links2.size();
			consoleMessage("Number of links are:" + count2);

			for (int i = 0; i < count2 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// CREATE THE RAMDOM MUNICIPAL ORDERS IN THE PROPERTY TWO
			title("CREATE THE RAMDOM MUNICIPAL ORDERS IN THE PROPERTY TWO");

			// ADD RECORD - MUNICIPAL ORDERSS
			title("ADD RECORD - MUNICIPAL ORDERSS");

			Random random2 = new Random();
			int mocount2 = random2.nextInt(5 - 1) + 1;
			consoleMessage("Municipal Orders Count in Property Two: " + mocount2);

			for (int i = 1; i <= mocount2; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				String projectreference2 = RandomStringUtils.randomAlphabetic(8);

				// enter the project reference
				type("propertyproject_mo_projectnumbertxt_CSS", projectreference2);

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY MUNICIPAL ORDERS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO
			title("VERIFY MUNICIPAL ORDERS COUNT ON PROPERTY LEVEL FOR THE PROPERTY TWO");

			// enter the property one name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			try {
				// wait for the element
				explicitWaitClickable("propertyproject_mo_countpropertylevel_XPATH");

				String actualCount2 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mo_countpropertylevel_XPATH"))).getText();

				String expectedCount2 = Integer.toString(mocount2);

				consoleMessage("The municipal orders actual count is : " + actualCount2 + " and expected count is : "
						+ expectedCount2);

				if (actualCount2.equals(expectedCount2)) {
					successMessage("The municipal orders counts are displayed correct in the property two.");
				} else {
					verificationFailedMessage(
							"The municipal orders counts are not displayed correct in the property two.");
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// DELETE MUNICIPAL ORDERSS OF PROPERTY ONE
		title("DELETE MUNICIPAL ORDERSS OF PROPERTY ONE");

		try {
			// enter the property one name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links3 = driver.findElements(By.xpath("//tr"));
			int count3 = links3.size();
			consoleMessage("Number of links are:" + count3);

			for (int i = 0; i < count3 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

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

		// DELETE MUNICIPAL ORDERSS OF PROPERTY TWO
		title("DELETE MUNICIPAL ORDERSS OF PROPERTY TWO");

		try {
			// enter the property two name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links4 = driver.findElements(By.xpath("//tr"));
			int count4 = links4.size();
			consoleMessage("Number of links are:" + count4);

			for (int i = 0; i < count4 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

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
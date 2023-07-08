package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5005PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5005PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5005PropertyProjectTwoTest");

		// CAPEX PROJECTS COUNTS ON A PROPERTY PROJECT DASHBOARD.
		title("CAPEX PROJECTS COUNTS ON A PROPERTY PROJECT DASHBOARD");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE CAPEX PROJECTS FROM THE PROPERTY ONE
		title("DELETE CAPEX PROJECTS FROM THE PROPERTY ONE");

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

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE
			title("CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY ONE");

			// ADD RECORD - CAPEX PROJECTS
			title("ADD RECORD - CAPEX PROJECTS");
			Random random = new Random();

			int cpcount1 = random.nextInt(5 - 1) + 1;
			consoleMessage("CAPEX Projects Count in Property One: " + cpcount1);

			for (int i = 1; i <= cpcount1; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				String projectnumber1 = RandomStringUtils.randomAlphabetic(8);

				// enter the project number
				type("propertyproject_cp_projectnumbertxt_CSS", projectnumber1);

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));

				// click on the data received field
				click("propertyproject_cp_datereceived_CSS");

				// click on the today button
				click("propertyproject_cp_datereceived_todaybtn_XPATH");

				// click on the save button
				click("propertyproject_cp_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY CAPEX PROJECTS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE
			// PROPERTY ONE
			title("VERIFY CAPEX PROJECTS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyproject_CSS");

			try {
				// wait for the element
				explicitWait("dashboard_CSS");

				// select the capex projects option from the dashboard dropdown
				select("dashboard_CSS", data.get("search_3"));

				// wait for the element
				explicitWait("propertyproject_mu_capexprojectstitle_XPATH");

				// scroll down the screen
				scrollByPixel(400);

				// enter the property name in the search field
				type("propertyproject_mu_propertyfiltertxt_CSS", data.get("property_1"));

				// hit enter key
				driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_propertyfiltertxt_CSS")))
						.sendKeys(Keys.ENTER);

				// verify count of CAPEX Projects is displayed correct or not
				List<WebElement> list1 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount1 = list1.size();

				consoleMessage(
						"The CAPEX Projects actual count is : " + listcount1 + " and expected count is : " + cpcount1);

				if (listcount1 == cpcount1) {
					successMessage("The CAPEX Projects counts are displayed correct for the property one.");
				} else {
					verificationFailedMessage(
							"The CAPEX Projects counts are not displayed correct for the property one");
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

		// DELETE CAPEX PROJECTS FROM THE PROPERTY TWO
		title("DELETE CAPEX PROJECTS FROM THE PROPERTY TWO");

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

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links2 = driver.findElements(By.xpath("//tr"));
			int count2 = links2.size();
			consoleMessage("Number of links are:" + count2);

			for (int i = 0; i < count2 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO
			title("CREATE THE RAMDOM CAPEX PROJECTS IN THE PROPERTY TWO");

			// ADD RECORD - CAPEX PROJECTS
			title("ADD RECORD - CAPEX PROJECTS");

			Random random2 = new Random();
			int cpcount2 = random2.nextInt(5 - 1) + 1;
			consoleMessage("CAPEX Projects Count in Property Two: " + cpcount2);

			for (int i = 1; i <= cpcount2; i++) {

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				String projectnumber2 = RandomStringUtils.randomAlphabetic(8);

				// enter the project number
				type("propertyproject_cp_projectnumbertxt_CSS", projectnumber2);

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));

				// click on the data received field
				click("propertyproject_cp_datereceived_CSS");

				// click on the today button
				click("propertyproject_cp_datereceived_todaybtn_XPATH");

				// click on the save button
				click("propertyproject_cp_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY CAPEX PROJECTS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE
			// PROPERTY TWO
			title("VERIFY CAPEX PROJECTS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property project side menu
			click("sidemenu_propertyproject_CSS");

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the CAPEX Projects option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_3"));

			// wait for the element
			explicitWait("propertyproject_mu_capexprojectstitle_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {

				// enter the property name in the search field
				type("propertyproject_mu_propertyfiltertxt_CSS", data.get("property_2"));

				// hit enter key
				driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_propertyfiltertxt_CSS")))
						.sendKeys(Keys.ENTER);

				// verify count of CAPEX Projects is displayed correct or not
				List<WebElement> list2 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount2 = list2.size();

				consoleMessage(
						"The CAPEX Projects actual count is : " + listcount2 + " and expected count is : " + cpcount2);

				if (listcount2 == cpcount2) {
					successMessage("The CAPEX Projects counts are displayed correct for the property two.");
				} else {
					verificationFailedMessage(
							"The CAPEX Projects counts are not displayed correct for the property two");
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

		// DELETE THE CAPEX PROJECTS
		title("DELETE CAPEX PROJECTS OF PROPERTY ONE");

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

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links3 = driver.findElements(By.xpath("//tr"));
			int count3 = links3.size();
			consoleMessage("Number of links are:" + count3);

			for (int i = 0; i < count3 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

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

		// DELETE CAPEX PROJECTS OF PROPERTY TWO
		title("DELETE CAPEX PROJECTS OF PROPERTY TWO");

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

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links4 = driver.findElements(By.xpath("//tr"));
			int count4 = links4.size();
			consoleMessage("Number of links are:" + count4);

			for (int i = 0; i < count4 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

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
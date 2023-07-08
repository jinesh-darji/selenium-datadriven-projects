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

public class RR5005PropertyProjectSixTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5005PropertyProjectSixTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5005PropertyProjectSixTest");

		// MUNICIPAL ORDERS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.
		title("MUNICIPAL ORDERS REPAIRS COUNTS ON A PROPERTY PROJECT DASHBOARD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE MUNICIPAL ORDERS REPAIRS FROM THE PROPERTY ONE
		title("DELETE MUNICIPAL ORDERS REPAIRS FROM THE PROPERTY ONE");

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

			// CREATE THE RAMDOM MUNICIPAL ORDERS REPAIRS IN THE PROPERTY ONE
			title("CREATE THE RAMDOM MUNICIPAL ORDERS REPAIRS IN THE PROPERTY ONE");

			// ADD RECORD - MUNICIPAL ORDERS REPAIRS
			title("ADD RECORD - MUNICIPAL ORDERS REPAIRS");

			Random random = new Random();
			int mocount1 = random.nextInt(5 - 1) + 1;
			consoleMessage("Municipal Orders Count in Property One: " + mocount1);

			try {
				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				// enter the project reference
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				for (int i = 1; i <= mocount1; i++) {

					String projectreferencerepair1 = RandomStringUtils.randomAlphabetic(8);

					// wait for the element
					explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

					// click on the new repair button
					click("propertyproject_mu_newrepairbtn_BTNTEXT");

					// scroll down the screen
					scrollByPixel(400);

					// enter the title of the repair
					type("propertyproject_mu_repair_titletxt_CSS", projectreferencerepair1);

					// enter the description
					type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

					// enter the unit number
					type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

					// click on assign to field
					click("propertyproject_mu_repair_assigntotxt_CSS");

					// click on the none button
					click("propertyproject_mu_repair_nonebtn_CSS");

					// enter username in search field
					type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

					// click on the searched username
					click("propertyproject_mu_repair_searcheduser_XPATH");

					// click on assign to field
					click("propertyproject_mu_repair_assigntotxt_CSS");

					// click on the save button
					click("propertyproject_mu_repair_savebtn_BTNTEXT");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");

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

			// VERIFY MUNICIPAL ORDERS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR
			// THE PROPERTY ONE
			title("VERIFY MUNICIPAL ORDERS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY ONE");

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

			// select the municipal orders repairs option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_5"));

			// wait for the element
			explicitWait("propertyproject_mu_municipalordersrepairstitle_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {

				// enter the property name in the search field
				type("propertyproject_mu_propertyfiltertxt_CSS", data.get("property_1"));

				// hit enter key
				driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_propertyfiltertxt_CSS")))
						.sendKeys(Keys.ENTER);

				// verify count of municipal orders repairs is displayed correct or not
				List<WebElement> list1 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount1 = list1.size();

				consoleMessage("The municipal orders repairs actual count is : " + listcount1
						+ " and expected count is : " + mocount1);

				if (listcount1 == mocount1) {
					successMessage("The municipal orders repairs counts are displayed correct for the property one.");
				} else {
					verificationFailedMessage(
							"The municipal orders repairs counts are not displayed correct for the property one");
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

		// DELETE MUNICIPAL ORDERS REPAIRS FROM THE PROPERTY TWO
		title("DELETE MUNICIPAL ORDERS REPAIRS FROM THE PROPERTY TWO");

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

			// CREATE THE RAMDOM MUNICIPAL ORDERS REPAIRS IN THE PROPERTY TWO
			title("CREATE THE RAMDOM MUNICIPAL ORDERS REPAIRS IN THE PROPERTY TWO");

			// ADD RECORD - MUNICIPAL ORDERS REPAIRS
			title("ADD RECORD - MUNICIPAL ORDERS REPAIRS");

			Random random = new Random();
			int mocount2 = random.nextInt(5 - 1) + 1;
			consoleMessage("Municipal Orders Count in Property One: " + mocount2);

			try {
				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				// enter the project reference
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference2"));

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				for (int i = 1; i <= mocount2; i++) {

					String projectreferencerepair2 = RandomStringUtils.randomAlphabetic(8);

					// wait for the element
					explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

					// click on the new repair button
					click("propertyproject_mu_newrepairbtn_BTNTEXT");

					// scroll down the screen
					scrollByPixel(400);

					// enter the title of the repair
					type("propertyproject_mu_repair_titletxt_CSS", projectreferencerepair2);

					// enter the description
					type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

					// enter the unit number
					type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

					// click on assign to field
					click("propertyproject_mu_repair_assigntotxt_CSS");

					// click on the none button
					click("propertyproject_mu_repair_nonebtn_CSS");

					// enter username in search field
					type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

					// click on the searched username
					click("propertyproject_mu_repair_searcheduser_XPATH");

					// click on assign to field
					click("propertyproject_mu_repair_assigntotxt_CSS");

					// click on the save button
					click("propertyproject_mu_repair_savebtn_BTNTEXT");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");

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

			// VERIFY MUNICIPAL ORDERS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR
			// THE PROPERTY TWO
			title("VERIFY MUNICIPAL ORDERS REPAIRS COUNT ON PROPERTY PROJECT DASHBOARD FOR THE PROPERTY TWO");

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

			// select the municipal orders repairs option from the dashboard dropdown
			select("dashboard_CSS", data.get("search_5"));

			// wait for the element
			explicitWait("propertyproject_mu_municipalordersrepairstitle_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {

				// enter the property name in the search field
				type("propertyproject_mu_propertyfiltertxt_CSS", data.get("property_2"));

				// hit enter key
				driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_propertyfiltertxt_CSS")))
						.sendKeys(Keys.ENTER);

				// verify count of municipal orders repairs is displayed correct or not
				List<WebElement> list2 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_dashboardconts_XPATH")));
				int listcount2 = list2.size();

				consoleMessage("The municipal orders repairs actual count is : " + listcount2
						+ " and expected count is : " + mocount2);

				if (listcount2 == mocount2) {
					successMessage("The municipal orders repairs counts are displayed correct for the property two.");
				} else {
					verificationFailedMessage(
							"The municipal orders repairs counts are not displayed correct for the property two");
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

		// DELETE MUNICIPAL ORDERS REPAIRS OF PROPERTY ONE
		title("DELETE MUNICIPAL ORDERS REPAIRS OF PROPERTY ONE");

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

			// click on the Municipal Orders
			click("propertyproject_mo_addedmunicipalorders_repairscount1_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			// click on the delete button of the repairs of the Municipal Orders
			List<WebElement> links3 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
			int count3 = links3.size();
			consoleMessage("Number of repair links are:" + count3);

			for (int i = 1; i <= count3; i++) {

				// scroll down to bottom
				scrollBottom();

				// click on repair randomly
				List<WebElement> links33 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
				int count33 = links33.size();
				consoleMessage("Remaining repair links after deleted the repair link: " + count33);

				Random r = new Random();
				links33.get(r.nextInt(count33)).click();

				// wait for the element
				explicitWaitClickable("task_deletedtaskbtn_CSS");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// wait for the element
				explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
			}

			// click on the update button
			click("propertyproject_mo_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// delete the Municipal Orders
			click("propertyproject_mo_deletebtn_CSS");

			// click on the delete button of confirmation
			click("propertyproject_mo_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE MUNICIPAL ORDERS REPAIRS OF PROPERTY TWO
		title("DELETE MUNICIPAL ORDERS REPAIRS OF PROPERTY TWO");

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

			// click on the Municipal Orders
			click("propertyproject_mo_addedmunicipalorders_repairscount2_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			// click on the delete button of the repairs of the Municipal Orders
			List<WebElement> links4 = driver
					.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
			int count4 = links4.size();
			consoleMessage("Number of repair links are:" + count4);

			for (int i = 1; i <= count4; i++) {

				// click on repair randomly
				List<WebElement> links44 = driver
						.findElements(By.xpath(OR.getProperty("propertyproject_mu_repairscount_XPATH")));
				int count44 = links44.size();
				consoleMessage("Remaining repair links after deleted the repair link: " + count44);

				Random r = new Random();
				links44.get(r.nextInt(count44)).click();

				// wait for the element
				explicitWaitClickable("task_deletedtaskbtn_CSS");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// wait for the element
				explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// click on the update button
			click("propertyproject_mo_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// delete the Municipal Orders
			click("propertyproject_mo_deletebtn_CSS");

			// click on the delete button of confirmation
			click("propertyproject_mo_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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
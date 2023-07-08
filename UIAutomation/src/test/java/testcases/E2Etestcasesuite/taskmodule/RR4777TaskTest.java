package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4777TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4777TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4777TaskTest");

		// CRUD OPERATION OF THE REPAIR OF THE MUNICIPAL ORDERS OF THE PROPERTY
		// PROJECTS.
		title("CRUD OPERATION OF THE REPAIR OF THE MUNICIPAL ORDERS OF THE PROPERTY PROJECTS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD MUNICIPAL ORDERS
		title("ADD MUNICIPAL ORDERS");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("propertyproject_municipalordersoption_XPATH");

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project Reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

			// scroll down the screen
			scrollByPixel(400);

			// wait for the element
			explicitWaitClickable("propertyproject_mu_repair_assigntotxt_CSS");

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

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair_XPATH", "Test Task Municipal Orders Title Record",
					"The Test Task Municipal Orders Title Record is not displayed.");

			// click on the update button
			click("propertyproject_mo_repair_updatebtn_CSS");

			// verification of the Municipal Orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders_XPATH", "PROJECTREFERENCE2021",
					"Municipal Orders is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE TASK FROM THE TASK MODULE
		title("UPDATE THE TASK FROM THE TASK MODULE");

		try {
			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair11_XPATH", "Test Task Municipal Orders Title Record",
					"The Test Task Municipal Orders Title Record is not displayed.");

			// click on the newly created task
			click("propertyproject_mo_addedrepair11_XPATH");

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));

			// click on the update button
			click("propertyproject_mu_updatetask_BTNTEXT");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("propertyproject_mo_updatedrepair11_XPATH",
					"Update Test Task Municipal Orders Title Record",
					"The Update Test Task Municipal Orders Title Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE MUNICIPAL ORDERS
		title("DELETE ALL THE MUNICIPAL ORDERS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("propertyproject_municipalordersoption_XPATH");

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// synchronization
			Thread.sleep(3000);

			// verification of the Municipal Orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders_XPATH", "PROJECTREFERENCE2021",
					"Municipal Orders is not displayed successfully.");

			// click on the Municipal Orders
			click("propertyproject_mo_addedmunicipalorders_XPATH");

			// scroll down the screen
			scrollByPixel(500);

			// verify newly created task is displayed or not
			switchVerification("propertyproject_mo_updatedrepair_XPATH",
					"Update Test Task Municipal Orders Title Record",
					"The Update Test Task Municipal Orders Title Record is not displayed.");

			// click on the cancel button
			click("propertyproject_mo_canceltask_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");

				// wait for element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");
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

		// VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT
		title("VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT");

		try {
			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the task is deleted or not
			helper.deleteVerification("propertyproject_mo_updatedrepair11_XPATH",
					"Update Test Task Municipal Orders Title Record");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
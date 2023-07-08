package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4717TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4717TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4717TaskTest");

		// CRUD OPERATION OF THE TASK OF THE RISK MANAGEMENT.
		title("CRUD OPERATION OF THE TASK OF THE RISK MANAGEMENT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD TASK IN THE RISK MANAGEMENT MODULE
		title("ADD TASK IN THE RISK MANAGEMENT MODULE");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");

			// click on the add button
			click("riskmanagement_addtaskbtn_CSS");

			// click on the recommendation field
			click("riskmanagement_addtaskbtn_recommendationtxt_CSS");

			// click on the clear button
			click("riskmanagement_addtaskbtn_recommendationclearbtn_XPATH");

			// enter the recommendation name
			type("task_filter_findtask_CSS", data.get("recommendation_name"));

			// click on the searched result
			click("riskmanagement_addtaskbtn_recommendationnametxt_XPATH");

			// enter description for task
			type("riskmanagement_addtaskbtn_descriptiontxt_CSS", data.get("description"));

			// scroll down the screen
			scrollByPixel(250);

			// select the insurance owner from the dropdown
			select("riskmanagement_addtaskbtn_forwho_CSS", data.get("insuranceOwner"));

			// scroll down the screen
			scrollByPixel(250);

			// click on the due date field
			click("riskmanagement_addtaskbtn_duedatetxt_CSS");

			// click on the today button
			click("riskmanagement_addtaskbtn_todayduedatebtn_XPATH");

			// click on the roles assigned field
			click("riskmanagement_addtaskbtn_roleassigntxt_CSS");

			// click on the none button
			click("riskmanagement_addtaskbtn_nonbtn_CSS");

			// enter role in search field
			type("riskmanagement_addtaskbtn_roleassignsearchtxt_CSS", data.get("role_assigned"));

			// click on the searched result
			click("riskmanagement_addtaskbtn_roleassignsearchresult_XPATH");

			// click on the roles assigned field
			click("riskmanagement_addtaskbtn_roleassigntxt_CSS");

			// click on the save button
			click("riskmanagement_addtaskbtn_savebtn_CSS");

			// enter recommendation name into the search field
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

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
			type("task_filter_CSS", data.get("recommendation_name"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask11_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

			// click on the newly created task
			click("riskmanagement_createdtask11_XPATH");

			// scroll down the screen
			scrollByPixel(200);

			// select the insurance owner from the dropdown
			select("riskmanagement_addtaskbtn_forwho_CSS", data.get("updated_insuranceOwner"));

			// click on the update button
			click("riskmanagement_updatetask_BTNTEXT");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("recommendation_name"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask11_XPATH", "Automation Type Risk",
					"The Automation Type Risk Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE TASK
		title("DELETE THE TASK");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");

			// synchronization
			explicitWait("riskmanagement_searchtxt_CSS");

			// enter recommendation name into the search field
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

			// verify updated value displayed or not
			switchVerification("riskmanagement_updatedtask_type_XPATH", "Tenant",
					"The updated details is not displayed.");

			// click on the newly created task
			click("riskmanagement_createdtask1_XPATH");

			// wait for element
			explicitWaitClickable("riskmanagement_deletetask_BTNTEXT");

			// click on the delete button
			click("riskmanagement_deletetask_BTNTEXT");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// synchronization
			explicitWait("riskmanagement_searchtxt_CSS");

			// enter recommendation name into the search field
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));

			helper.deleteVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk");

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
			type("task_filter_CSS", data.get("recommendation_name"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			helper.deleteVerification("riskmanagement_createdtask11_XPATH", "Automation Type Risk");

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
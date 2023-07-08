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

		System.out.println("CRUD OPERATION OF THE TASK OF THE RISK MANAGEMENT.");
		test.log(LogStatus.INFO, "CRUD OPERATION OF THE TASK OF THE RISK MANAGEMENT.");
		Reporter.log("CRUD OPERATION OF THE TASK OF THE RISK MANAGEMENT.");
		log.info("CRUD OPERATION OF THE TASK OF THE RISK MANAGEMENT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD TASK IN THE RISK MANAGEMENT MODULE

		System.out.println("***************** ADD TASK IN THE RISK MANAGEMENT MODULE *****************");
		test.log(LogStatus.INFO, "***************** ADD TASK IN THE RISK MANAGEMENT MODULE *****************");
		Reporter.log("***************** ADD TASK IN THE RISK MANAGEMENT MODULE *****************");
		log.info("***************** ADD TASK IN THE RISK MANAGEMENT MODULE *****************");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			System.out.println("Clicked on the risk management icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the risk management screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");
			System.out.println("Clicked on the tasks option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("riskmanagement_addtaskbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add risk management Screen");

			// click on the recommendation field
			click("riskmanagement_addtaskbtn_recommendationtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the recommendation field.");

			// click on the clear button
			click("riskmanagement_addtaskbtn_recommendationclearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the recommendation name
			type("task_filter_findtask_CSS", data.get("recommendation_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the recommendation name.");

			// click on the searched result
			click("riskmanagement_addtaskbtn_recommendationnametxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// enter description for task
			type("riskmanagement_addtaskbtn_descriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered description for task.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)");

			// select the insurance owner from the dropdown
			select("riskmanagement_addtaskbtn_forwho_CSS", data.get("insuranceOwner"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the insurance owner from the dropdown.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,250)");

			// click on the due date field
			click("riskmanagement_addtaskbtn_duedatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the due date field.");

			// click on the today button
			click("riskmanagement_addtaskbtn_todayduedatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// click on the roles assigned field
			click("riskmanagement_addtaskbtn_roleassigntxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles assigned field.");

			// click on the none button
			click("riskmanagement_addtaskbtn_nonbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter role in search field
			type("riskmanagement_addtaskbtn_roleassignsearchtxt_CSS", data.get("role_assigned"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered role in search field.");

			// click on the searched result
			click("riskmanagement_addtaskbtn_roleassignsearchresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the roles assigned field
			click("riskmanagement_addtaskbtn_roleassigntxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles assigned field.");

			// click on the save button
			click("riskmanagement_addtaskbtn_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter recommendation name into the search field
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered recommendation name into the search field.");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

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

		// UPDATE THE TASK FROM THE TASK MODULE

		title("UPDATE THE TASK FROM THE TASK MODULE");

		try {

			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("recommendation_name"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask11_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

			// click on the newly created task
			click("riskmanagement_createdtask11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// select the insurance owner from the dropdown
			select("riskmanagement_addtaskbtn_forwho_CSS", data.get("updated_insuranceOwner"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the insurance owner from the dropdown.");

			// click on the update button
			click("riskmanagement_updatetask_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("recommendation_name"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask11_XPATH", "Automation Type Risk",
					"The Automation Type Risk Record is not displayed.");

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

		// DELETE THE TASK

		System.out.println("***************** DELETE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
		Reporter.log("***************** DELETE THE TASK *****************");
		log.info("***************** DELETE THE TASK *****************");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			System.out.println("Clicked on the risk management icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the risk management screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("riskmanagement_taskoption_CSS");

			// click on the tasks
			click("riskmanagement_taskoption_CSS");
			System.out.println("Clicked on the tasks option.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("riskmanagement_searchtxt_CSS");

			// enter recommendation name into the search field
			clear("riskmanagement_searchtxt_CSS");
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered recommendation name into the search field.");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk",
					"The automation type risk is not displayed.");

			// verify updated value displayed or not
			switchVerification("riskmanagement_updatedtask_type_XPATH", "Tenant",
					"The updated details is not displayed.");

			// click on the newly created task
			click("riskmanagement_createdtask1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// wait for element
			explicitWaitClickable("riskmanagement_deletetask_BTNTEXT");

			// click on the delete button
			click("riskmanagement_deletetask_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup.");

			// synchronization
			explicitWait("riskmanagement_searchtxt_CSS");

			// enter recommendation name into the search field
			clear("riskmanagement_searchtxt_CSS");
			type("riskmanagement_searchtxt_CSS", data.get("recommendation_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered recommendation name into the search field.");

			helper.deleteVerification("riskmanagement_createdtask1_XPATH", "Automation Type Risk");

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

		// VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT

		System.out.println("***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");
		Reporter.log("***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");
		log.info("***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");

		try {
			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("recommendation_name"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			helper.deleteVerification("riskmanagement_createdtask11_XPATH", "Automation Type Risk");

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

	}
}

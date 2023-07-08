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

		System.out.println("CRUD OPERATION OF THE REPAIR OF THE MUNICIPAL ORDERS OF THE PROPERTY PROJECTS.");
		test.log(LogStatus.INFO, "CRUD OPERATION OF THE REPAIR OF THE MUNICIPAL ORDERS OF THE PROPERTY PROJECTS.");
		Reporter.log("CRUD OPERATION OF THE REPAIR OF THE MUNICIPAL ORDERS OF THE PROPERTY PROJECTS.");
		log.info("CRUD OPERATION OF THE REPAIR OF THE MUNICIPAL ORDERS OF THE PROPERTY PROJECTS.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD MUNICIPAL ORDERS

		System.out.println("**************** ADD MUNICIPAL ORDERS ****************");
		test.log(LogStatus.INFO, "**************** ADD MUNICIPAL ORDERS ****************");
		Reporter.log("**************** ADD MUNICIPAL ORDERS ****************");
		log.info("**************** ADD MUNICIPAL ORDERS ****************");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("propertyproject_municipalordersoption_XPATH");

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the project Reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));
			System.out.println("Entered the project Reference.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Municipality.");

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_repair_assigntotxt_CSS");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));
			System.out.println("Entered username in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched username.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("propertyproject_mu_repair_savebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair_XPATH", "Test Task Municipal Orders Title Record",
					"The Test Task Municipal Orders Title Record is not displayed.");

			// click on the update button
			click("propertyproject_mo_repair_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the Municipal Orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders_XPATH", "PROJECTREFERENCE2021",
					"Municipal Orders is not displayed successfully.");

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

		System.out.println("***************** UPDATE THE TASK FROM THE TASK MODULE *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE TASK FROM THE TASK MODULE *****************");
		Reporter.log("***************** UPDATE THE TASK FROM THE TASK MODULE *****************");
		log.info("***************** UPDATE THE TASK FROM THE TASK MODULE *****************");

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
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair11_XPATH", "Test Task Municipal Orders Title Record",
					"The Test Task Municipal Orders Title Record is not displayed.");

			// click on the newly created task
			click("propertyproject_mo_addedrepair11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// update the title of the task
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated data in the task title.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("propertyproject_mu_updatetask_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// scroll up the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("propertyproject_mo_updatedrepair11_XPATH",
					"Update Test Task Municipal Orders Title Record",
					"The Update Test Task Municipal Orders Title Record is not displayed.");

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

		// DELETE ALL THE MUNICIPAL ORDERS

		System.out.println("***************** DELETE ALL THE MUNICIPAL ORDERS *****************");
		test.log(LogStatus.INFO, "***************** DELETE ALL THE MUNICIPAL ORDERS *****************");
		Reporter.log("***************** DELETE ALL THE MUNICIPAL ORDERS *****************");
		log.info("***************** DELETE ALL THE MUNICIPAL ORDERS *****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("propertyproject_municipalordersoption_XPATH");

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			Thread.sleep(3000);

			// verification of the Municipal Orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders_XPATH", "PROJECTREFERENCE2021",
					"Municipal Orders is not displayed successfully.");

			// click on the Municipal Orders
			click("propertyproject_mo_addedmunicipalorders_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Municipal Orders.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// verify newly created task is displayed or not
			switchVerification("propertyproject_mo_updatedrepair_XPATH",
					"Update Test Task Municipal Orders Title Record",
					"The Update Test Task Municipal Orders Title Record is not displayed.");

			// click on the cancel button
			click("propertyproject_mo_canceltask_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
				click("propertyproject_mo_deletebtn_CSS");
				System.out.println("Deleted the all the Municipal Orders");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

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
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the task is deleted or not
			helper.deleteVerification("propertyproject_mo_updatedrepair11_XPATH",
					"Update Test Task Municipal Orders Title Record");

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

package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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

public class RR4826PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4826PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4826PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE CAPEX PROJECTS MODULE.

		System.out.println("PREPARE THE CRUD OPERATION OF THE CAPEX PROJECTS MODULE.");
		test.log(LogStatus.INFO, "PREPARE THE CRUD OPERATION OF THE CAPEX PROJECTS MODULE.");
		Reporter.log("PREPARE THE CRUD OPERATION OF THE CAPEX PROJECTS MODULE.");
		log.info("PREPARE THE CRUD OPERATION OF THE CAPEX PROJECTS MODULE.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD CAPEX PROJECTS

		System.out.println("**************** ADD CAPEX PROJECTS ****************");
		test.log(LogStatus.INFO, "**************** ADD CAPEX PROJECTS ****************");
		Reporter.log("**************** ADD CAPEX PROJECTS ****************");
		log.info("**************** ADD CAPEX PROJECTS ****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Project option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - CAPEX Project

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Project Screen");

			// enter the project number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the engineering company
			select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the engineering company.");

			// click on the data received field
			click("propertyproject_cp_datereceived_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the data received field.");

			// click on the today button
			click("propertyproject_cp_datereceived_todaybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// click on the save button
			click("propertyproject_cp_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

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

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// DETAILS OF COST / BUDGET TAB

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// ADD NEWLY CONTRACTOR

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add contractor icon.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the contractor name.");

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the telephone number.");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the city name.");

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the province name.");

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the country name.");

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the contractor field.");

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the po number.");

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the estimate amount.");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the budget amount.");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the final cost.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// DETAILS OF COMPLETION TAB

			// click on the completion tab
			click("propertyproject_cp_completiontab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the completion tab.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// enter data in the percentage completion field
			type("propertyproject_cp_completiontab_percentagecompletiontxt_CSS", "60");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the percentage completion field.");

			// enter in the completion note field
			type("propertyproject_cp_completiontab_completionnote_CSS", data.get("completion_note"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered in the completion note field.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_cp_addedrepair_XPATH", "Test CRUD CAPEX Projects Title Record",
					"The Test CRUD CAPEX Projects Title Record is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the CAPEX Projects is added or not
			switchVerification("propertyproject_cp_addedcapexprojects1_XPATH", "PROJECTNAME2021",
					"The PROJECTNAME2021 is not displayed successfully.");

			// UPDATE THE CAPEX Projects

			System.out.println("**************** UPDATE CAPEX Projects ****************");
			test.log(LogStatus.INFO, "**************** UPDATE CAPEX Projects ****************");
			Reporter.log("**************** UPDATE CAPEX Projects ****************");
			log.info("**************** UPDATE CAPEX Projects ****************");

			// UPDATE THE DETAILS OF THE REPAIR

			// click on the newly created CAPEX Projects
			click("propertyproject_cp_addedcapexprojects1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created CAPEX Projects.");

			// update the title of the undertaking number
			clear("propertyproject_cp_projectnumbertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the title field.");
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("update the title of the undertaking number.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the newly created repair
			click("propertyproject_cp_addedrepair_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created repair.");

			// click on the details tab
			click("propertyproject_mu_detailstab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the details tab.");

			// click on the start button
			click("propertyproject_mu_repair_startbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the start button.");

			// update the title of the repair
			clear("propertyproject_mu_repair_titletxt_CSS");
			type("propertyproject_mu_repair_titletxt_CSS", data.get("update_task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("update the title of the repair.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			Thread.sleep(5000);

			// verify updated repair title is displayed or not
			switchVerification("propertyproject_cp_updatedrepair_task_XPATH",
					"Update Test CRUD CAPEX Projects Title Record",
					"The Update Test CRUD CAPEX Projects Title Record is not displayed.");

			// verify updated repair status is displayed or not
			switchVerification("propertyproject_mu_updatedrepair2_XPATH", "In_progress",
					"The In_progress is not displayed.");

			// COMMENT TAB DETAILS

			// click on the comment tab
			click("propertyproject_mu_commentab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the comment tab.");

			// enter the comment
			type("propertyproject_mu_commenttxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the comment.");

			// click on the update button
			click("propertyproject_cp_repair_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// verification of the CAPEX Projects is added or not
			switchVerification("propertyproject_cp_updatedcapexprojects1_XPATH", "UPDATEPROJECTNAME2021",
					"The UPDATEPROJECTNAME2021 is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE CAPEX Projects

			System.out.println("**************** DELETE CAPEX Projects ****************");
			test.log(LogStatus.INFO, "**************** DELETE CAPEX Projects ****************");
			Reporter.log("**************** DELETE CAPEX Projects ****************");
			log.info("**************** DELETE CAPEX Projects ****************");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Projects option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the updated CAPEX Projects
			click("propertyproject_cp_updatedcapexprojects1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created CAPEX Projects.");

			// verify updated repair title is displayed or not
			switchVerification("propertyproject_cp_updatedrepair_task_XPATH",
					"Update Test CRUD CAPEX Projects Title Record",
					"The Update Test CRUD CAPEX Projects Title Record is not displayed.");

			// verify updated repair status is displayed or not
			switchVerification("propertyproject_mu_updatedrepair2_XPATH", "In_progress",
					"The In_progress is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the updated repair
			click("propertyproject_cp_updatedrepair_task_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated repair.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify repair is deleted or not

			helper.deleteVerification("propertyproject_cp_updatedrepair_task_XPATH",
					"Update Test CRUD CAPEX Projects Title Record");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");
				System.out.println("Deleted the all the CAPEX Projects");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created CAPEX Projects is deleted or not

			helper.deleteVerification("propertyproject_cp_updatedcapexprojects1_XPATH", "UPDATEPROJECTNAME2021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
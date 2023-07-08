package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4778TaskOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4778TaskOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4778TaskOneTest");

		// ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE
		// THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.

		System.out.println(
				"ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.");
		test.log(LogStatus.INFO,
				"ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.");
		Reporter.log(
				"ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.");
		log.info(
				"ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// SET THE PERMISSIONS FOR THE ROLE

		System.out.println("***************** SET THE PERMISSIONS FOR THE ROLE *****************");
		test.log(LogStatus.INFO, "***************** SET THE PERMISSIONS FOR THE ROLE *****************");
		Reporter.log("***************** SET THE PERMISSIONS FOR THE ROLE *****************");
		log.info("***************** SET THE PERMISSIONS FOR THE ROLE *****************");

		try {
			// wait for element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on he settings icon.");

			// wait for element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles option.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// collect all the roles

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Contractor")) {

							// click on the Contractor role
							click("task_permission_roles_XPATH");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the Contractor role.");
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				System.out.println("Successfully navigate to the Role Details screen.");
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			// verify internal role check box is selected or not
			boolean internalrole = driver.findElement(By.cssSelector("input[name='internalRole']")).isSelected();

			if (internalrole == true) {
				System.out.println("The internal role is displayed selected.");
				test.log(LogStatus.INFO, "The internal role is displayed selected.");
				Reporter.log("The internal role is displayed selected.");
				log.info("The internal role is displayed selected.");
			} else {

				// click on the internal role checklist
				click("task_permission_roles_internalrole_CSS");
				ngDriver.waitForAngularRequestsToFinish();

				System.out.println("Clicked on the internal role checklist.");
				test.log(LogStatus.INFO, "Clicked on the internal role checklist.");
				Reporter.log("Clicked on the internal role checklist.");
				log.info("Clicked on the internal role checklist.");
			}

			// click on the save button
			click("task_permission_roles_saverolebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGIN WITH CONTRACTOR USER 1

		System.out.println("***************** LOGIN WITH CONTRACTOR USER 1 *****************");
		test.log(LogStatus.INFO, "***************** LOGIN WITH CONTRACTOR USER 1 *****************");
		Reporter.log("***************** LOGIN WITH CONTRACTOR USER 1 *****************");
		log.info("***************** LOGIN WITH CONTRACTOR USER 1 *****************");

		try {
			// wait for the element
			Thread.sleep(7000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// CREATE NEW TASK

			System.out.println("***************** CREATE NEW TASK *****************");
			test.log(LogStatus.INFO, "***************** CREATE NEW TASK *****************");
			Reporter.log("***************** CREATE NEW TASK *****************");
			log.info("***************** CREATE NEW TASK *****************");

			try {
				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the add task button
				click("task_addtaskbtn_CSS");
				System.out.println("Clicked on the add task button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", data.get("task_title"));
				System.out.println("Entered the data in the task title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task location field
				type("task_addtask_locationtxt_CSS", data.get("task_location"));
				System.out.println("Entered the data in the task location field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the none button
				click("task_tasktag_nonebtn_CSS");
				System.out.println("Clicked on the none button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
				System.out.println("Entered the user name in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("task_permission_task_selectusertxt_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1200)");

				// synchronization
				explicitWait("task_addtask_moduledd_CSS");

				// select the environmental option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));
				System.out.println("Selected the environmental option from the module dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("survey_task_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

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

				// wait for the element
				Thread.sleep(5000);

				// verify newly created task is displayed or not
//				switchVerification("task_permission_taskpermission_addedtask1_XPATH", "Test Task Permission One Title",
//						"The Test Task Permission One Title is not displayed.");

				try {
					String str2 = (driver
							.findElement(By.xpath("//p[contains(text(),'Test Task Permission One Title')]")).getText())
									.trim();
					ngDriver.waitForAngularRequestsToFinish();
					if (str2.equals("Test Task Permission One Title")) {

						System.out.println("The Test Task Permission One Title is verified successfully.");
						test.log(LogStatus.INFO, "The Test Task Permission One Title is verified successfully.");
						Reporter.log("The Test Task Permission One Title is verified successfully.");
						log.info("The Test Task Permission One Title is verified successfully.");
					} else {
						verificationFailed();
					}
				} catch (Throwable t) {
					verificationFailed();
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

			// LOGIN WITH VENDER USER

			System.out.println("***************** LOGIN WITH VENDER USER *****************");
			test.log(LogStatus.INFO, "***************** LOGIN WITH VENDER USER *****************");
			Reporter.log("***************** LOGIN WITH VENDER USER *****************");
			log.info("***************** LOGIN WITH VENDER USER *****************");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.loginAndUpdateSystemCompany(data, "username_2", "password", "system_company_1");

			// CREATE NEW TASK

			System.out.println("***************** CREATE NEW TASK *****************");
			test.log(LogStatus.INFO, "***************** CREATE NEW TASK *****************");
			Reporter.log("***************** CREATE NEW TASK *****************");
			log.info("***************** CREATE NEW TASK *****************");

			try {
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

				try {
					String str3 = driver
							.findElement(By.xpath(OR.getProperty("task_permission_taskpermission_addedtask1_XPATH")))
							.getText();
					ngDriver.waitForAngularRequestsToFinish();
					if (str3.equals("Test Task Permission One Title")) {

						Assert.assertTrue(
								isElementPresent(
										By.xpath(OR.getProperty("task_permission_taskpermission_addedtask1_XPATH"))),
								"The Test Task Permission One Title is not displayed.");

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "Verification failure : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " Verification failed with exception : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The task is display successfully.");
						log.info("The task is display successfully.");

					}
				} catch (Throwable t) {
					System.out.println("The task is not displayed as per the expected.");
					test.log(LogStatus.INFO, "The task is not displayed as per the expected.");
					Reporter.log("The task is not displayed as per the expected.");
					log.info("The task is not displayed as per the expected.");
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

			// LOGIN WITH ADMIN USER

			System.out.println("***************** LOGIN WITH PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO, "***************** LOGIN WITH PROPERTY MANAGER USER *****************");
			Reporter.log("***************** LOGIN WITH PROPERTY MANAGER USER *****************");
			log.info("***************** LOGIN WITH PROPERTY MANAGER USER *****************");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.loginAndUpdateSystemCompany(data, "username1", "password", "system_company_1");

			// UPDATE THE TASK

			System.out.println("***************** UPDATE THE TASK *****************");
			test.log(LogStatus.INFO, "***************** UPDATE THE TASK *****************");
			Reporter.log("***************** UPDATE THE TASK *****************");
			log.info("***************** UPDATE THE TASK *****************");

			try {
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

				// wait for the element
				Thread.sleep(5000);

				// click on the newly created task
				driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission One Title')]")).click();
				System.out.println("Click on the newly created task.");
				ngDriver.waitForAngularRequestsToFinish();

				try {
					// update the title of the task
					type("task_addtask_titletxt_CSS", data.get("update_task_title"));
					System.out.println("Entered the updated data in the task title.");
					ngDriver.waitForAngularRequestsToFinish();

					// click on the update button
					click("survey_task_updatebtn_CSS");
					System.out.println("Clicked on the update button.");
					ngDriver.waitForAngularRequestsToFinish();

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the toaster close button.");

					// click on the back button
					driver.findElement(
							By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']")).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the back button.");

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

					// verify updated task is displayed or not
					try {
						String str2 = (driver
								.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]"))
								.getText()).trim();
						ngDriver.waitForAngularRequestsToFinish();
						if (str2.equals("Update Test Task Permission One Title")) {

							System.out.println("The Update Test Task Permission One Title is verified successfully.");
							test.log(LogStatus.INFO,
									"The Update Test Task Permission One Title is verified successfully.");
							Reporter.log("The Update Test Task Permission One Title is verified successfully.");
							log.info("The Update Test Task Permission One Title is verified successfully.");
						} else {
							verificationFailed();
						}
					} catch (Throwable t) {
						verificationFailed();
					}

					verificationFailedMessage(
							"The property manager user able to update the details, without permission.");

				} catch (Throwable t) {

					successMessage("The property manager user not able to update the details, As expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// DELETE THE TASK

			System.out.println("*****************  DELETE THE TASK *****************");
			test.log(LogStatus.INFO, "*****************  DELETE THE TASK *****************");
			Reporter.log("*****************  DELETE THE TASK *****************");
			log.info("*****************  DELETE THE TASK *****************");

			try {
				// click on the newly created task
				driver.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]")).click();
				System.out.println("Click on the updated task.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for element
				explicitWaitClickable("task_deletedtaskbtn_CSS");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");
				System.out.println("Clicked on the delete button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for element
				explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");
				System.out.println("Clicked on the delete button of the confirmation popup.");
				ngDriver.waitForAngularRequestsToFinish();

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

				// wait for the element
				Thread.sleep(5000);

				// verify the questionnaire deleted or not

//				deleteVerification("task_permission_taskpermission_updatedtask1_XPATH",
//						"Update Test Task Permission One Title");

				try {

					String deleteElement = driver
							.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]"))
							.getText();

					if (deleteElement.equals("Update Test Task Permission One Title")) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The  Update Test Task Permission One Title is not deleted : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Update Test Task Permission One Title is not deleted : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Update Test Task Permission One Title is not deleted.");
						log.info("The Update Test Task Permission One Title is not deleted.");

					}
				} catch (Throwable t) {
					System.out.println("The Update Test Task Permission One Title is deleted successfully.");
					test.log(LogStatus.INFO, "The Update Test Task Permission One Title is deleted successfully.");
					Reporter.log("The Update Test Task Permission One Title is deleted successfully.");
					log.info("The Update Test Task Permission One Title is deleted successfully.");
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

			// LOGIN WITH CONTRACTOR USER 1

			System.out.println("***************** LOGIN WITH CONTRACTOR USER 1 *****************");
			test.log(LogStatus.INFO, "***************** LOGIN WITH CONTRACTOR USER 1 *****************");
			Reporter.log("***************** LOGIN WITH CONTRACTOR USER 1 *****************");
			log.info("***************** LOGIN WITH CONTRACTOR USER 1 *****************");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY TASK IS DISPLAYED OR NOT

			System.out.println("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
			test.log(LogStatus.INFO, "***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
			Reporter.log("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
			log.info("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");

			try {
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

				try {

					String deleteElement1 = (driver
							.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]"))
							.getText()).trim();

					if (deleteElement1.equals("Update Test Task Permission One Title")) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The  Update Test Task Permission One Title is not deleted : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Update Test Task Permission One Title is not deleted : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Update Test Task Permission One Title is not deleted.");
						log.info("The Update Test Task Permission One Title is not deleted.");

					}
				} catch (Throwable t) {
					System.out.println("The Update Test Task Permission One Title is deleted successfully.");
					test.log(LogStatus.INFO, "The Update Test Task Permission One Title is deleted successfully.");
					Reporter.log("The Update Test Task Permission One Title is deleted successfully.");
					log.info("The Update Test Task Permission One Title is deleted successfully.");
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

			// LOGIN WITH ADMIN USER

			System.out.println("***************** LOGIN WITH ADMIN USER *****************");
			test.log(LogStatus.INFO, "***************** LOGIN WITH ADMIN USER *****************");
			Reporter.log("***************** LOGIN WITH ADMIN USER *****************");
			log.info("***************** LOGIN WITH ADMIN USER *****************");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// LOGIN WITH ADMIN USER

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE APPLIED PERMISSION ON THE ROLE

		System.out.println("***************** RESET THE APPLIED PERMISSION ON THE ROLE *****************");
		test.log(LogStatus.INFO, "***************** RESET THE APPLIED PERMISSION ON THE ROLE *****************");
		Reporter.log("***************** RESET THE APPLIED PERMISSION ON THE ROLE *****************");
		log.info("***************** RESET THE APPLIED PERMISSION ON THE ROLE *****************");

		try {

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on he settings icon.");

			// wait for element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles option.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// collect all the roles

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Contractor")) {

							// click on the Contractor role
							click("task_permission_roles_XPATH");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the Contractor role.");
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				System.out.println("Successfully navigate to the Role Details screen.");
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			// verify internal role check box is selected or not
			boolean internalrole1 = driver.findElement(By.cssSelector("input[name='internalRole']")).isSelected();

			if (internalrole1 == true) {
				System.out.println("The internal role is displayed selected.");
				test.log(LogStatus.INFO, "The internal role is displayed selected.");
				Reporter.log("The internal role is displayed selected.");
				log.info("The internal role is displayed selected.");
			} else {

				// click on the internal role checklist
				click("task_permission_roles_internalrole_CSS");
				test.log(LogStatus.INFO, "Clicked on the internal role checklist.");
				Reporter.log("Clicked on the internal role checklist.");
				log.info("Clicked on the internal role checklist.");
			}

			// click on the save button
			click("task_permission_roles_saverolebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}

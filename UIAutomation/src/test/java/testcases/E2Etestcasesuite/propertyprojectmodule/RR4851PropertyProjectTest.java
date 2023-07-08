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

public class RR4851PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4851PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4851PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE MUNICIPAL ORDERS MODULE.
		title("PREPARE THE CRUD OPERATION OF THE MUNICIPAL ORDERS MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD Municipal Orders
		title("ADD Municipal Orders");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// ADD RECORD - Municipal Orders
			title("ADD RECORD - Municipal Orders");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

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

			// scroll up the screen
			scrollByPixel(-400);

			// DETAILS OF COST / BUDGET TAB
			title("DETAILS OF COST / BUDGET TAB");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// ADD NEWLY CONTRACTOR
			title("ADD NEWLY CONTRACTOR");

			// click on the add contractor icon
			click("propertyproject_mu_addcontractoricon_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// generate the random contractor name
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the contractor name
			type("propertyproject_mu_contractornametxt_CSS", s);

			// enter the telephone number
			type("propertyproject_mu_telephonetxt_CSS", "9876543210");

			// enter the city name
			type("propertyproject_mu_citytxt_CSS", data.get("city"));

			// enter the province name
			type("propertyproject_mu_provincetxt_CSS", data.get("province"));

			// enter the country name
			type("propertyproject_mu_countrytxt_CSS", data.get("country"));

			// click on the save button
			click("propertyproject_mu_contrctorsavebtn_CSS");

			// CONTINUE ON DETAILS OF COST / BUDGET TAB
			title("CONTINUE ON DETAILS OF COST / BUDGET TAB");

			// scroll down the screen
			scrollByPixel(400);

			// wait for the element
			explicitWait("propertyproject_mu_contrctortxt_CSS");

			// select on the contractor field
			select("propertyproject_mu_contrctortxt_CSS", s);

			// enter the po number
			type("propertyproject_mu_ponumbertxt_CSS", data.get("task_ponumber"));

			// enter the estimate amount
			type("propertyproject_mu_estimateamounttxt_CSS", "332211");

			// enter the budget amount
			type("propertyproject_mu_budgetamounttxt_CSS", "665544");

			// enter the final cost
			type("propertyproject_mu_finalcosttxt_CSS", "998877");

			// scroll up the screen
			scrollByPixel(-400);

//		// DETAILS OF THE ATTACHMENT TAB
//
//		// click on the attachment tab
//		click("propertyproject_mu_attachmenttab_CSS");
//		 
//		 
//
//		// scroll down the screen
//		scrollByPixel(400);
//
//		// AUTO IT Concept
//		
//		// click on the local upload file button
//		WebElement chooseFile = driver
//				.findElement(By.cssSelector(OR.getProperty("task_addtask_attachmentstab_uploadlocalfilebtn_CSS")));
//		chooseFile.click();
//		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Upload.exe");
//		 
//
//		// ROBOT CLASS Concept
//		
//		// click on the upload local file
//		click("propertyproject_mu_uploaddocumentbtn_CSS");
//		 
//		 
//		
//		// upload the document using robot class methods
//		uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf");
//		
//		// wait for 10 seconds
//		Thread.sleep(10000);
//
//		// verify uploaded file is displayed or not
//		try {
//			String str1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS")))
//					.getText();
//
//			if (str1.equals("sample.pdf")) {
//				 
//				test.log(LogStatus.INFO, "The uploaded file displayed successfully.");
//				Reporter.log("The uploaded file displayed successfully.");
//				log.info("The uploaded file displayed successfully.");
//
//			} else {
//				Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS"))),
//						"The The uploaded file is not displayed.");
//
//				TestUtil.captureScreenshot();
//
//				// ReportNG
//				Reporter.log("<br>" + "The The uploaded file is not displayed : " + "<br>");
//				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
//						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
//				Reporter.log("<br>");
//				Reporter.log("<br>");
//
//				// Extent Report
//				test.log(LogStatus.FAIL, " The The uploaded file is not displayed: ");
//				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
//
//				 
//				log.info("The The uploaded file is not displayed.");
//			}
//
//		} catch (Throwable t) {
//			Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS"))),
//					"The The uploaded file is not displayed.");
//
//			TestUtil.captureScreenshot();
//
//			// ReportNG
//			Reporter.log("<br>" + "The The uploaded file is not displayed : " + "<br>");
//			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
//					+ " height=200 width=200></img></a>");
//			Reporter.log("<br>");
//			Reporter.log("<br>");
//
//			// Extent Report
//			test.log(LogStatus.FAIL, " The The uploaded file is not displayed: ");
//			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
//
//			 
//			log.info("The The uploaded file is not displayed.");
//		}
//
//		// COMMENT TAB DETAILS
//		
//		// click on the comment tab
//		click("propertyproject_mu_commentab_CSS");
//		 
//		 
//		
//		// enter the comment
//		type("propertyproject_mu_commenttxt_CSS", data.get("short_description"));
//		 
//		 

//		// click on the save button
//		click("propertyproject_mu_tasksavebtn_BTNTEXT");
//		 
//		 

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// wait for the element
			explicitWait("propertyproject_mo_addedrepair1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mo_addedrepair1_XPATH", "Test CRUD Municipal Orders Title Record",
					"The Test CRUD Municipal Orders Title Record is not displayed.");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// verification of the Municipal Orders is added or not
			switchVerification("propertyproject_mo_addedmunicipalorders1_XPATH", "PROJECTREFERENCE2021",
					"The PROJECTREFERENCE2021 is not displayed successfully.");

			// UPDATE THE Municipal Orders
			title("UPDATE THE Municipal Orders");

			// UPDATE THE DETAILS OF THE REPAIR
			title("UPDATE THE DETAILS OF THE REPAIR");

			// click on the newly created Municipal Orders
			click("propertyproject_mo_addedmunicipalorders1_XPATH");

			// update the title of the undertaking number
			type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_reference"));

			// scroll down the screen
			scrollByPixel(400);

			// click on the newly created repair
			click("propertyproject_mo_addedrepair1_XPATH");

			// click on the details tab
			click("propertyproject_mu_detailstab_XPATH");

			// click on the start button
			click("propertyproject_mu_repair_startbtn_CSS");

			// update the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("update_task_title"));

			// wait for the element
			explicitWaitClickable("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// wait for the element
			explicitWait("propertyproject_mo_updatedrepair1_XPATH");

			// verify updated repair title is displayed or not
			switchVerification("propertyproject_mo_updatedrepair1_XPATH",
					"Update Test CRUD Municipal Orders Title Record",
					"The Update Test CRUD Municipal Orders Title Record is not displayed.");

			// verify updated repair status is displayed or not
			switchVerification("propertyproject_mu_updatedrepair2_XPATH", "In_progress",
					"The In_progress is not displayed.");

			// COMMENT TAB DETAILS
			title("COMMENT TAB DETAILS");

			// click on the comment tab
			click("propertyproject_mu_commentab_CSS");

			// enter the comment
			type("propertyproject_mu_commenttxt_CSS", data.get("short_description"));

			// click on the update button
			click("propertyproject_mo_repair_updatebtn_CSS");

			// verification of the Municipal Orders is added or not
			switchVerification("propertyproject_mo_updatedmunicipalorders1_XPATH", "UPDATEPROJECTREFERENCE2021",
					"The UPDATEPROJECTREFERENCE2021 is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE Municipal Orders
			title("DELETE THE Municipal Orders");

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

			// click on the updated Municipal Orders
			click("propertyproject_mo_updatedmunicipalorders1_XPATH");

			// wait for the element
			explicitWait("propertyproject_mo_updatedrepair1_XPATH");

			// verify updated repair title is displayed or not
			switchVerification("propertyproject_mo_updatedrepair1_XPATH",
					"Update Test CRUD Municipal Orders Title Record",
					"The Update Test CRUD Municipal Orders Title Record is not displayed.");

			// verify updated repair status is displayed or not
			switchVerification("propertyproject_mu_updatedrepair2_XPATH", "In_progress",
					"The In_progress is not displayed.");

			// DELETE THE REPAIR
			title("DELETE THE REPAIR");

			// scroll down the screen
			scrollByPixel(400);

			// click on the updated repair
			click("propertyproject_mo_updatedrepair1_XPATH");

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

			// verify repair is deleted or not
			helper.deleteVerification("propertyproject_mo_updatedrepair1_XPATH",
					"Update Test CRUD Municipal Orders Title Record");

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

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

			// verify newly created Municipal Orders is deleted or not
			helper.deleteVerification("propertyproject_mo_updatedmunicipalorders1_XPATH", "UPDATEPROJECTREFERENCE2021");

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
package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6202SurveyChecklist1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6202SurveyChecklist1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6202SurveyChecklist1Test");

		// VALIDATE THE CATEGORIZE PHOTOS SCREEN AND COUNT OF THE RESPECTIVE ATTACHMENTS
		// ON THE CATEGORIZE PHOTOS SCREEN AND CLASSIC VIEW OF THE INSPECTION.

		consoleMessage(
				"VALIDATE THE CATEGORIZE PHOTOS SCREEN AND COUNT OF THE RESPECTIVE ATTACHMENTS ON THE CATEGORIZE PHOTOS SCREEN AND CLASSIC VIEW OF THE INSPECTION.");
		test.log(LogStatus.INFO,
				"VALIDATE THE CATEGORIZE PHOTOS SCREEN AND COUNT OF THE RESPECTIVE ATTACHMENTS ON THE CATEGORIZE PHOTOS SCREEN AND CLASSIC VIEW OF THE INSPECTION.");
		Reporter.log(
				"VALIDATE THE CATEGORIZE PHOTOS SCREEN AND COUNT OF THE RESPECTIVE ATTACHMENTS ON THE CATEGORIZE PHOTOS SCREEN AND CLASSIC VIEW OF THE INSPECTION.");
		successMessage(
				"VALIDATE THE CATEGORIZE PHOTOS SCREEN AND COUNT OF THE RESPECTIVE ATTACHMENTS ON THE CATEGORIZE PHOTOS SCREEN AND CLASSIC VIEW OF THE INSPECTION.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		 

		// ADD NEW QUESTIONNIRE FOR INSPECTION

		title("ADD NEW QUESTIONNIRE FOR INSPECTION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			 
			 

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			 
			 

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			 
			 

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			 
			 

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			 
			 
			 

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");
			 

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			 

			// enter the group title
			 
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			 

			// enter the questionnaire title
			 
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			 
			 

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			 
			 

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			 
			 

			// enter frequency interval
			 
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			 
			 

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			 
			 

			// enter the description
			 
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			 
			 

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			 
			 

			// scroll down to the save button
			 
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			 
			 
			 

			// enter newly created questionnaire in the filter field
			 
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			 
			 

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addphoto1_XPATH", "Questionnaire Add Photo One Title",
					"The Questionnaire Add Photo One Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			 
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			successMessage("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_addphoto1_XPATH");
			 
			 

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			 
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			 
			 

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addphoto1_XPATH", "Questionnaire Add Photo One Title",
					"The Questionnaire Add Photo One Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE INSPECTION AT PROPERTY LEVEL

		title("CREATE INSPECTION AT PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			 
			 
			 

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			 
			 

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			 
			 

			try {
				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// collect all options of the dropdown
				Select dropdown = new Select(driver
						.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

				// Get all options
				List<WebElement> dd = dropdown.getOptions();

				// Loop to print one by one
				for (int j = 0; j < dd.size(); j++) {
					String checklist = dd.get(j).getText();
					try {
						if (checklist.equals(data.get("questionnaire_checklist_title"))) {

							test.log(LogStatus.INFO, "The checklist is displayed successfully.");
							Reporter.log("The checklist is displayed successfully.");
							 
							successMessage("The checklist is displayed successfully.");

							// select the questionnaire option from the checklist type dropdown
							select("checklist_addchecklist_checklisttypedd_CSS",
									data.get("questionnaire_checklist_title"));
							System.out
									.println("The created questionaaire is selected from the checklist type dropdown.");
							 

							// enter data in the checklist title field
							 
							type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
							 
							 

							// click on the save button
							click("checklist_addchecklist_savebtn_CSS");
							 
							 

							// verify questionnaire is selected correctly or not
							switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
									"The Test Category Title One is not displayed.");

						}
					} catch (Throwable t) {

						verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
								+ " is not displayed in the dropdown.");

						// click on the close button of the add checklist popup
						click("checklist_addchecklist_dltbtn_XPATH");
						 
						 

					}
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// UPLOAD THE ATTACHMENTS/PHOTOS FROM THE SYSTEM

		title("UPLOAD THE ATTACHMENTS/PHOTOS FROM THE SYSTEM");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			 
			 
			 

			// enter the inspection name in the search field
			 
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			 
			 

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();
			 
			 

			// click on the categorize photo button
			click("questionnaire_inspection_photobtn_XPATH");
			 
			 

			// click on the add attachments/photos icon
			click("questionnaire_inspection_photo_addphoto_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// upload the first document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf");

			// wait for the element
			Thread.sleep(5000);

			// click on the ok button
			click("questionnaire_inspection_photo_okbtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			// click on the add attachments/photos icon
			click("questionnaire_inspection_photo_addphoto_XPATH");
			 
			 

			// upload the second document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_1.jpg");

			// wait for the element
			Thread.sleep(5000);

			// click on the ok button
			click("questionnaire_inspection_photo_okbtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			// click on the add attachments/photos icon
			click("questionnaire_inspection_photo_addphoto_XPATH");
			 
			 

			// upload the third document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_2.jpg");

			// wait for the element
			Thread.sleep(5000);

			// click on the ok button
			click("questionnaire_inspection_photo_okbtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			// click on the add attachments/photos icon
			click("questionnaire_inspection_photo_addphoto_XPATH");
			 
			 

			// upload the fourth document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_3.jpg");

			// wait for the element
			Thread.sleep(5000);

			// click on the ok button
			click("questionnaire_inspection_photo_okbtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			// click on the add attachments/photos icon
			click("questionnaire_inspection_photo_addphoto_XPATH");
			 
			 

			// upload the fifth document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_4.jpg");

			// wait for the element
			Thread.sleep(5000);

			// click on the ok button
			click("questionnaire_inspection_photo_okbtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SELECT THE ATTACHMENTS/PHOTOS FOR LINK TO THE RESPECTIVE CATEGORIES

		title("SELECT THE ATTACHMENTS/PHOTOS FOR LINK TO THE RESPECTIVE CATEGORIES");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			 
			 
			 

			// enter the inspection name in the search field
			 
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			 
			 

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();
			 
			 

			// click on the categorize photo button
			click("questionnaire_inspection_photobtn_XPATH");
			 
			 

			// click on the first file for category one
			String file1 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[1]";
			driver.findElement(By.xpath(file1)).click();
			 
			 

			// click on the second file for category one
			String file2 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[2]";
			driver.findElement(By.xpath(file2)).click();
			 
			 

			// click on the third file for category one
			String file3 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[3]";
			driver.findElement(By.xpath(file3)).click();
			 
			 

			// click on the category one title
			click("questionnaire_inspection_photo_category1_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			// validate the count of the files of the category one
			try {
				String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
				String category1_actual = (driver.findElement(By.xpath(category1)).getText()).trim();
				consoleMessage("PHOTO COUNT: " + category1_actual);

				if (category1_actual.equals("3")) {
					successMessage("The count of the uploaded files of the category one are displayed correctly.");
				} else {
					verificationFailedMessage(
							"The count of the uploaded files of the category one are not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of the uploaded files of the category one are not displayed correctly.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the fourth file for category two
			String file4 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[1]";
			driver.findElement(By.xpath(file4)).click();
			 
			 

			// click on the fifth file for category one
			String file5 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[2]";
			driver.findElement(By.xpath(file5)).click();
			 
			 

			// click on the category two title
			click("questionnaire_inspection_photo_category2_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(10000);

			// validate the count of the files of the category two
			try {
				String category2 = "//b[text()='Test Category Title Two Two']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
				String category2_actual = (driver.findElement(By.xpath(category2)).getText()).trim();

				if (category2_actual.equals("2")) {
					successMessage("The count of the uploaded files of the category two are displayed correctly.");
				} else {
					verificationFailedMessage(
							"The count of the uploaded files of the category two are not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of the uploaded files of the category two are not displayed correctly.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the back button
			click("questionnaire_inspection_photo_backbtn_XPATH");
			 
			 

			// validate the count of the files of category one on classic view screen

			try {
				String fileCount1 = (driver
						.findElement(By.xpath(
								OR.getProperty("questionnaire_inspection_photo_category1_classicviewcount_XPATH")))
						.getText()).trim();
				String[] fileCount1_arr = fileCount1.split(" ");
				String fileCount1_ClassicView = fileCount1_arr[0];

				if (fileCount1_ClassicView.equals("3")) {
					successMessage("The file counts of the category one are displayed correctly on classic view.");
				} else {
					verificationFailedMessage(
							"The file counts of the category one are not displayed correctly on classic view.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The file counts of the category one are not displayed correctly on classic view.");
			}

			// validate the count of the files of category two on classic view screen

			try {
				String fileCount2 = (driver
						.findElement(By.xpath(
								OR.getProperty("questionnaire_inspection_photo_category2_classicviewcount_XPATH")))
						.getText()).trim();
				String[] fileCount2_arr = fileCount2.split(" ");
				String fileCount2_ClassicView = fileCount2_arr[0];

				if (fileCount2_ClassicView.equals("2")) {
					successMessage("The file counts of the category two are displayed correctly on classic view.");
				} else {
					verificationFailedMessage(
							"The file counts of the category two are not displayed correctly on classic view.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The file counts of the category two are not displayed correctly on classic view.");
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

		// DELETE THE NEWLY CREATED INSPECTION

		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			 
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			 
			 
			 

			// enter the inspection name in the search field
			 
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			 
			 

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			 
			 

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_deletebtn_XPATH");
			 
			 

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED QUESTIONNAIRES

		title("DELETE THE NEWLY CREATED QUESTIONNAIRES");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			 
			 

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			 
			 

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			 
			 

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			 
			 

			// enter newly created questionnaire in the filter field
			 
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			 
			 

			// click on the created questionnaire
			click("questionnaire_addphoto1_XPATH");
			 
			 

			// scroll down to bottom of the screen
			 
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_wizard_deletebtn_XPATH");
			 
			 

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup model
			click("checklist_wizard_confirmationdeletebtn_XPATH");
			 
			 

			// enter newly created questionnaire in the filter field
			 
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			 
			 

			// validate whether the questionnaire deleted or not
			helper.deleteVerification("questionnaire_addphoto1_XPATH", "Questionnaire Add Photo One Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		 
		 

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}

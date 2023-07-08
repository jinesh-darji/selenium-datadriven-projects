package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.File;
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

public class RR6202SurveyChecklist2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6202SurveyChecklist2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6202SurveyChecklist2Test");

		// VALIDATE THE ACTIONS OF THE ATTACHMENTS/PHOTOS OF THE CATEGORIZE PHOTOS
		// SCREEN

		System.out.println("VALIDATE THE ACTIONS OF THE ATTACHMENTS/PHOTOS OF THE CATEGORIZE PHOTOS SCREEN.");
		test.log(LogStatus.INFO, "VALIDATE THE ACTIONS OF THE ATTACHMENTS/PHOTOS OF THE CATEGORIZE PHOTOS SCREEN.");
		Reporter.log("VALIDATE THE ACTIONS OF THE ATTACHMENTS/PHOTOS OF THE CATEGORIZE PHOTOS SCREEN.");
		log.info("VALIDATE THE ACTIONS OF THE ATTACHMENTS/PHOTOS OF THE CATEGORIZE PHOTOS SCREEN.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE FOR INSPECTION

		title("ADD NEW QUESTIONNIRE FOR INSPECTION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			clear("questionnaire_grouptitletxt_CSS");
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			clear("questionnaire_languagetitle_CSS");
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered the questionnaire title in the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			System.out.println("The data entered in the frequency field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			clear("questionnaire_frequencyintervaltxt_CSS");
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			clear("questionnaire_descriptiontxt_CSS");
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down to the save button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addphoto2_XPATH", "Questionnaire Add Photo Two Title",
					"The Questionnaire Add Photo Two Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_addphoto2_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addphoto2_XPATH", "Questionnaire Add Photo Two Title",
					"The Questionnaire Add Photo Two Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the Home Icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE INSPECTION AT PROPERTY LEVEL

		title("CREATE INSPECTION AT PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

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
							System.out.println("The checklist is displayed successfully.");
							log.info("The checklist is displayed successfully.");

							// select the questionnaire option from the checklist type dropdown
							select("checklist_addchecklist_checklisttypedd_CSS",
									data.get("questionnaire_checklist_title"));
							System.out
									.println("The created questionaaire is selected from the checklist type dropdown.");
							ngDriver.waitForAngularRequestsToFinish();

							// enter data in the checklist title field
							clear("checklist_addchecklist_titletxt_CSS");
							type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
							System.out.println("Entered the data in the checklist title field.");
							ngDriver.waitForAngularRequestsToFinish();

							// click on the save button
							click("checklist_addchecklist_savebtn_CSS");
							System.out.println("Clicked on the save button.");
							ngDriver.waitForAngularRequestsToFinish();

							// verify questionnaire is selected correctly or not
							switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
									"The Test Category Title One is not displayed.");

						}
					} catch (Throwable t) {

						verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
								+ " is not displayed in the dropdown.");

						// click on the close button of the add checklist popup
						click("checklist_addchecklist_dltbtn_XPATH");
						System.out.println("Clicked on the close button of the add checklist popup.");
						ngDriver.waitForAngularRequestsToFinish();

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPLOAD THE ATTACHMENTS/PHOTOS FROM THE SYSTEM AND SELECT THE
		// ATTACHMENTS/PHOTOS FOR LINK TO THE RESPECTIVE CATEGORIES

		title("UPLOAD THE ATTACHMENTS/PHOTOS FROM THE SYSTEM AND SELECT THE ATTACHMENTS/PHOTOS FOR LINK TO THE RESPECTIVE CATEGORIES");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly searched inspection.");

			// click on the categorize photo button
			click("questionnaire_inspection_photobtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the categorize photo button.");

			// click on the add attachments/photos icon
			click("questionnaire_inspection_photo_addphoto_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add attachments/photos icon.");

			// wait for the element
			Thread.sleep(5000);

			// upload the second document
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Image_1.jpg");

			// wait for the element
			Thread.sleep(5000);

			// click on the ok button
			click("questionnaire_inspection_photo_okbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the ok button.");

			// wait for the element
			Thread.sleep(10000);

			// click on the first file for category one
			String file1 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[1]";
			driver.findElement(By.xpath(file1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first file for category one.");

			// click on the category one title
			click("questionnaire_inspection_photo_category1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the category one title.");

			// wait for the element
			Thread.sleep(5000);

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

		// PERFORED THE ALL THE ACTIONS WITH THE LINKED ATTACHMENTS/PHOTOS

		title("PERFORED THE ALL THE ACTIONS WITH THE LINKED ATTACHMENTS/PHOTOS");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly searched inspection.");

			// click on the categorize photo button
			click("questionnaire_inspection_photobtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the categorize photo button.");

			// ADD THE CAPTION TEXT TO THE ATTACHMENTS/PHOTOS

			title("ADD THE CAPTION TEXT TO THE ATTACHMENTS/PHOTOS");

			try {
				boolean redIcon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_photo_rediconcolor_XPATH")))
						.isDisplayed();

				if (redIcon == false) {

					// click on the count of the attachments/photos count of category one
					String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
					driver.findElement(By.xpath(category1)).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the count of the attachments/photos count of category one.");

					successMessage("The linked attachments/photos of the category one is displayed.");

				} else {
					successMessage("The linked attachments/photos of the category one is displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The attachments/photos icon is not displayed.");
			}

			// click on the uploaded image
			click("questionnaire_inspection_photo_imageclass_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the uploaded image.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// enter the details in the caption field
			clear("questionnaire_inspection_photo_captiontxt_XPATH");
			type("questionnaire_inspection_photo_captiontxt_XPATH", data.get("caption"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the caption field.");

			// click on the close button
			click("questionnaire_inspection_photo_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// wait for the element
			Thread.sleep(3000);

			// validate the caption is displayed or not on the categorize photo screen
			try {
				String caption = "//span[text()='" + data.get("caption") + "']";
				boolean captionText = driver.findElement(By.xpath(caption)).isDisplayed();

				if (captionText == true) {

					successMessage("The caption text is displayed successfully.");

				} else {
					verificationFailedMessage("The caption text is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The caption text is not displayed.");
			}

			// REMOVED THE CAPTION TEXT TO THE ATTACHMENTS/PHOTOS

			title("REMOVED THE CAPTION TEXT TO THE ATTACHMENTS/PHOTOS");

			try {
				boolean redIcon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_photo_rediconcolor_XPATH")))
						.isDisplayed();

				if (redIcon == false) {

					// click on the count of the attachments/photos count of category one
					String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
					driver.findElement(By.xpath(category1)).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the count of the attachments/photos count of category one.");

					successMessage("The linked attachments/photos of the category one is displayed.");

				} else {
					successMessage("The linked attachments/photos of the category one is displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The attachments/photos icon is not displayed.");
			}

			// click on the uploaded image
			click("questionnaire_inspection_photo_imageclass_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the uploaded image.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// clear the caption field
			clear("questionnaire_inspection_photo_captiontxt_XPATH");

			// click on the close button
			click("questionnaire_inspection_photo_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// wait for the element
			Thread.sleep(3000);

			// validate the caption is displayed or not on the categorize photo screen
			try {
				String caption = "//span[text()='" + data.get("caption") + "']";
				boolean captionText = driver.findElement(By.xpath(caption)).isDisplayed();

				if (captionText == true) {

					verificationFailedMessage("The caption text is displayed however the caption text is removed.");

				} else {
					successMessage("The caption text is not displayed when the caption text is removed.");
				}

			} catch (Throwable t) {
				successMessage("The caption text is not displayed when the caption text is removed.");
			}

			// VALIDATE THE DOWNLOAD THE FILE FEATURE

			title("VALIDATE THE DOWNLOAD THE FILE FEATURE");

			try {
				boolean redIcon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_photo_rediconcolor_XPATH")))
						.isDisplayed();

				if (redIcon == false) {

					// click on the count of the attachments/photos count of category one
					String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
					driver.findElement(By.xpath(category1)).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the count of the attachments/photos count of category one.");

					successMessage("The linked attachments/photos of the category one is displayed.");

				} else {
					successMessage("The linked attachments/photos of the category one is displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The attachments/photos icon is not displayed.");
			}

			// click on the uploaded image
			click("questionnaire_inspection_photo_imageclass_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the uploaded image.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// enter the details in the caption field
			clear("questionnaire_inspection_photo_captiontxt_XPATH");
			type("questionnaire_inspection_photo_captiontxt_XPATH", data.get("caption"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the caption field.");

			// click on the download button
			click("questionnaire_inspection_photo_downloadbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the download button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// ************ BELOW - TEMPORARY CODE **************

			// ********************** add fetch file code **********************

//				String path_string = chosenFile.toString();
//				String[] chosenFile_arr = path_string.split(" ");
//				String fileName = chosenFile_arr[0];

//				if (fileName.equals("Image_1")) {
//					successMessage("The file downloaded successfully.");
//				} else {
//					verificationFailedMessage("The file not downloaded correctly.");
//				}

//			} catch (Throwable t) {
//				verificationFailed();
//			}

			// ************ ABOVE - TEMPORARY CODE **************

			// VALIDATE THE REMOVE FROM BUTTON

			title("VALIDATE THE REMOVE FROM BUTTON");

			try {
				boolean redIcon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_photo_rediconcolor_XPATH")))
						.isDisplayed();

				if (redIcon == false) {

					// click on the count of the attachments/photos count of category one
					String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
					driver.findElement(By.xpath(category1)).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the count of the attachments/photos count of category one.");

					successMessage("The linked attachments/photos of the category one is displayed.");

				} else {
					successMessage("The linked attachments/photos of the category one is displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The attachments/photos icon is not displayed.");
			}

			// click on the uploaded image
			click("questionnaire_inspection_photo_imageclass_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the uploaded image.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// enter the details in the caption field
			clear("questionnaire_inspection_photo_captiontxt_XPATH");
			type("questionnaire_inspection_photo_captiontxt_XPATH", data.get("caption"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the caption field.");

			// click on the remove from button
			click("questionnaire_inspection_photo_removefrombtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the remove from button.");

			// wait for the element
			Thread.sleep(5000);

			// validate the count of the files of the category one
			try {
				String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
				String category1_actual = (driver.findElement(By.xpath(category1)).getText()).trim();
				System.out.println("PHOTO COUNT: " + category1_actual);

				if (category1_actual.equals("0")) {
					successMessage("The count of the uploaded files of the category one are displayed correctly.");
				} else {
					verificationFailedMessage(
							"The count of the uploaded files of the category one are not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of the uploaded files of the category one are not displayed correctly.");
			}

			// VALIDATE THE DELETE FILE FEATURE

			title("VALIDATE THE DELETE FILE FEATURE");

			// wait for the element
			Thread.sleep(5000);

			// click on the first file for category one
			String file1 = "(//input[@ng-click='selectS3ClientFileForAssociation()'])[1]";
			driver.findElement(By.xpath(file1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first file for category one.");

			// click on the category one title
			click("questionnaire_inspection_photo_category1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the category one title.");

			// wait for the element
			Thread.sleep(5000);

			try {
				boolean redIcon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_photo_rediconcolor_XPATH")))
						.isDisplayed();

				if (redIcon == false) {

					// click on the count of the attachments/photos count of category one
					String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
					driver.findElement(By.xpath(category1)).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the count of the attachments/photos count of category one.");

					successMessage("The linked attachments/photos of the category one is displayed.");

				} else {
					successMessage("The linked attachments/photos of the category one is displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The attachments/photos icon is not displayed.");
			}

			// click on the uploaded image
			click("questionnaire_inspection_photo_imageclass_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the uploaded image.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// enter the details in the caption field
			clear("questionnaire_inspection_photo_captiontxt_XPATH");
			type("questionnaire_inspection_photo_captiontxt_XPATH", data.get("caption"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the caption field.");

			// click on the delete button
			click("questionnaire_inspection_photo_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// validate the count of the files of the category one
			try {
				String category1 = "//b[text()='Test Category Title One']//parent::label[@class='col-md-9 pointer-underline']//following-sibling::div[@class='pull-right']//a[@title='Total count of associated photos']//b[@class='ng-binding']";
				String category1_actual = (driver.findElement(By.xpath(category1)).getText()).trim();
				System.out.println("PHOTO COUNT: " + category1_actual);

				if (category1_actual.equals("0")) {
					successMessage("The count of the uploaded files of the category one are displayed correctly.");
				} else {
					verificationFailedMessage(
							"The count of the uploaded files of the category one are not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of the uploaded files of the category one are not displayed correctly.");
			}

			// validate the uploaded file is displayed or not

			try {

				boolean uploadedFile = driver
						.findElement(By.xpath("(//input[@ng-click='selectS3ClientFileForAssociation()'])[1]"))
						.isDisplayed();

				if (uploadedFile == true) {

					verificationFailedMessage("The uploaded file is displayed however the file is deleted.");

				} else {
					successMessage("The uploaded file is not displayed after the file is deleted.");
				}

			} catch (Throwable t) {

				successMessage("The uploaded file is not displayed after the file is deleted.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE NEWLY CREATED INSPECTION

		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

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
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("questionnaire_addphoto2_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down to bottom of the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_wizard_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup model
			click("checklist_wizard_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup model.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// validate whether the questionnaire deleted or not
			helper.deleteVerification("questionnaire_addphoto2_XPATH", "Questionnaire Add Photo Two Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}

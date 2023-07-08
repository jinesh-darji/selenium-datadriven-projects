package base;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import utilities.TestUtil;

public class Helper extends TestBase {

	public void rolePermissionValidation(String role, String permissionName, String permissionColumn, String color,
			String behaviour) throws IOException, InterruptedException {
		try {
			boolean permission = driver
					.findElement(By.xpath("//div[contains(text(),'" + role + "')]//parent::td//following-sibling::td["
							+ permissionColumn + "]/i[@class='icon-" + behaviour + " i-" + color + "']"))
					.isDisplayed();

			if (permission == true) {
				 
				test.log(LogStatus.INFO, "THE " + permissionName + " PERMISSION IS GIVERN TO THE " + role + " ROLE.");
				Reporter.log("THE " + permissionName + " PERMISSION IS GIVERN TO THE " + role + " ROLE.");
				log.info("THE " + permissionName + " PERMISSION IS GIVERN TO THE " + role + " ROLE.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "THE " + permissionName + " PERMISSION IS NOT GIVERN TO THE " + role + " ROLE."
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						"THE " + permissionName + " PERMISSION IS NOT GIVERN TO THE " + role + " ROLE.");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				 
				log.info("THE " + permissionName + " PERMISSION IS NOT GIVERN TO THE " + role + " ROLE.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void defaultExecutiveOptionValidation(String role, String roleLocator)
			throws IOException, InterruptedException {

		try {
			// scroll down the screen
			 
			scrollByPixel(200);

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

						if (getrole.equalsIgnoreCase(role)) {

							// click on the role
							click(roleLocator);
							 
							 
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					 
					 

				}
			} catch (Throwable t) {
				 
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			boolean executiveOption = driver
					.findElement(By.xpath(OR.getProperty("task_permission_role_executivedd_XPATH"))).isDisplayed();

			if (executiveOption == true) {
				 
				test.log(LogStatus.INFO, "THE EXECUTIVE OPTION IS DISPLAYED AS A DEFAULT OPTION.");
				Reporter.log("THE EXECUTIVE OPTION IS DISPLAYED AS A DEFAULT OPTION.");
				log.info("THE EXECUTIVE OPTION IS DISPLAYED AS A DEFAULT OPTION.");
			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + " THE EXECUTIVE OPTION IS NOT DISPLAYED AS A DEFAULT OPTION. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " THE EXECUTIVE OPTION IS NOT DISPLAYED AS A DEFAULT OPTION. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				 
				log.info("THE EXECUTIVE OPTION IS NOT DISPLAYED AS A DEFAULT OPTION.");

			}

			// scroll UP the screen
			scrollByPixel(-200);

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	public void createEnvironmentalReport(Hashtable<String, String> data, String type, String title)
			throws InterruptedException {

		// click on the add button
		click("envreportaddbtn_CSS");
		 
		 

		// select the checklist from the type dropdown
		select("envreporttypedd_CSS", type);
		 
		 

		// enter the title
		type("envreporttitletxt_CSS", title);
		 
		 

		// scroll down the screen
		 
		scrollByPixel(400);

		// click on the date field
		click("envreportdatetxt_CSS");
		 
		 

		// click on the today button
		click("envreporttodaydate_BTNTEXT");
		 
		 

		// click on the save report button
		click("envreportsavebtn_CSS");
		 
		 

		// wait for the element
		explicitWaitClickable("closetoastmsg_CSS");

		// click on the toaster close button
		click("closetoastmsg_CSS");
		 
		 

		// wait for the element
		Thread.sleep(3000);

	}

	public void createAsbestosMaterialRecord(Hashtable<String, String> data, String material, String detailed_location,
			String is_material_asbestos_containing, String asbestos_type, String condition, String status)
			throws InterruptedException {

		// click on the add button
		click("envreports_asbestosmaterials_addbtn_CSS");
		 
		 
		 

		// select the material
		select("envreports_asbestosmaterials_materialdd_CSS", material);
		 
		 

		// enter the detailed location
		type("envreports_asbestosmaterials_detailedlocationtxt_CSS", detailed_location);
		 
		 

		// scroll down the screen
		 
		scrollByPixel(400);

		// select the is material asbestos containing
		select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS", is_material_asbestos_containing);
		 
		 

		// select the asbestos type
		select("envreports_asbestosmaterials_asbestostypedd_CSS", asbestos_type);
		 
		 

		// select the condition
		select("envreports_asbestosmaterials_conditiondd_CSS", condition);
		 
		 

		// select the status
		select("envreports_asbestosmaterials_statusdd_CSS", status);
		 
		 

		// scroll till bottom of the page
		scrollByPixel(400);

		// click on the save button
		click("envreports_asbestosmaterials_savebtn_CSS");
		 
		 

		// wait for the element
		explicitWaitClickable("closetoastmsg_CSS");

		// click on the toaster close button
		click("closetoastmsg_CSS");
		 
		 
	}

	public void verifyNACheckedCheckbox(String location) {
		try {
			boolean nacheckbox = driver.findElement(By.xpath(OR.getProperty(location))).isDisplayed();

			if (nacheckbox == true) {

				// click on the n/a checkbox of category 1 question 1
				click(location);
				 
				 

				 
				test.log(LogStatus.INFO, "CLICKED ON THE NA CHECKBOX.");
				Reporter.log("CLICKED ON THE NA CHECKBOX.");
				log.info("CLICKED ON THE NA CHECKBOX.");

			} else {
				 
				test.log(LogStatus.INFO, "THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
				Reporter.log("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
				log.info("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
			}
		} catch (Throwable t) {
			 
			test.log(LogStatus.INFO, "THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
			Reporter.log("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
			log.info("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
		}
	}

	public void verifyNAUncheckedCheckbox(String location) {
		try {
			boolean nacheckbox = driver.findElement(By.xpath(OR.getProperty(location))).isDisplayed();

			if (nacheckbox == true) {

				// click on the n/a checkbox of category 1 question 1
				click(location);
				 
				System.out.println("Clicked on the n/a checkbox to uncheck." + location);

				 
				test.log(LogStatus.INFO, "CLICKED ON THE NA CHECKBOX.");
				Reporter.log("CLICKED ON THE NA CHECKBOX.");
				log.info("CLICKED ON THE NA CHECKBOX.");

			} else {
				 
				test.log(LogStatus.INFO, "THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
				Reporter.log("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
				log.info("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
			}
		} catch (Throwable t) {
			 
			test.log(LogStatus.INFO, "THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
			Reporter.log("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
			log.info("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
		}
	}

	public void scrollDownToNextNACheckbox(String location1, String location2) {

		try {
			boolean nacheckbox = driver.findElement(By.xpath(OR.getProperty(location1))).isDisplayed();

			if (nacheckbox == true) {

				// scroll down the screen
				WebElement ele1 = driver.findElement(By.xpath(OR.getProperty(location1)));
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].scrollIntoView(true);", ele1);
				js1.executeScript("window.scrollBy(0,-200)");

				System.out.println("THE SCROLL DOWN THE SCREEN TILL ." + location1);
				test.log(LogStatus.INFO, "THE SCROLL DOWN THE SCREEN TILL ." + location1);
				Reporter.log("THE SCROLL DOWN THE SCREEN TILL ." + location1);
				log.info("THE SCROLL DOWN THE SCREEN TILL ." + location1);

			} else {
				// scroll down the screen
				WebElement ele11 = driver.findElement(By.xpath(OR.getProperty(location2)));
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].scrollIntoView(true);", ele11);
				js2.executeScript("window.scrollBy(0,-200)");

				System.out.println("THE SCROLL DOWN THE SCREEN TILL ." + location2);
				test.log(LogStatus.INFO, "THE SCROLL DOWN THE SCREEN TILL ." + location2);
				Reporter.log("THE SCROLL DOWN THE SCREEN TILL ." + location2);
				log.info("THE SCROLL DOWN THE SCREEN TILL ." + location2);
			}
		} catch (Throwable t) {

			// scroll down the screen
			WebElement ele2 = driver.findElement(By.xpath(OR.getProperty(location2)));
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView(true);", ele2);
			js3.executeScript("window.scrollBy(0,-200)");

			System.out.println("THE SCROLL DOWN THE SCREEN TILL ." + location2);
			test.log(LogStatus.INFO, "THE SCROLL DOWN THE SCREEN TILL ." + location2);
			Reporter.log("THE SCROLL DOWN THE SCREEN TILL ." + location2);
			log.info("THE SCROLL DOWN THE SCREEN TILL ." + location2);

		}
	}

	public void loginAndUpdateSystemCompany(Hashtable<String, String> data, String username, String password,
			String SystemCompany) throws IOException, InterruptedException {

		// LOGIN WITH VALID CREDENTIALS

		 
		log.info("********** LOGIN WITH VALID CREDENTIALS **********");
		Reporter.log("********** LOGIN WITH VALID CREDENTIALS **********");
		test.log(LogStatus.INFO, "********** LOGIN WITH VALID CREDENTIALS **********");

		try {

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("username_MODEL", data.get(username));
			 
			 

			// Enter the password
			type("password_MODEL", data.get(password));
			 
			 

			// Click on the Sign In button
			click("signinbtn_BTNTEXT");
			 
			 

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// update the system company
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	public void questionnaireNotDisplayLogout(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			 
			test.log(LogStatus.INFO, "AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
			Reporter.log("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
			log.info("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");

			verificationFailed();

			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.navigate().refresh();

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			 
			 

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			 
			 

			// LOGIN WITH ADMIN USER

			 
			test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
			Reporter.log("********** LOGIN WITH ADMIN USER **********");
			log.info("********** LOGIN WITH ADMIN USER **********");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			 
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			 

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// update the system company
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}
	}

}

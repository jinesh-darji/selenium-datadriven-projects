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
				System.out.println("THE " + permissionName + " PERMISSION IS GIVERN TO THE " + role + " ROLE.");
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

				System.out.println("THE " + permissionName + " PERMISSION IS NOT GIVERN TO THE " + role + " ROLE.");
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

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
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the " + role + " role.");
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

			boolean executiveOption = driver
					.findElement(By.xpath(OR.getProperty("task_permission_role_executivedd_XPATH"))).isDisplayed();

			if (executiveOption == true) {
				System.out.println("THE EXECUTIVE OPTION IS DISPLAYED AS A DEFAULT OPTION.");
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

				System.out.println("THE EXECUTIVE OPTION IS NOT DISPLAYED AS A DEFAULT OPTION.");
				log.info("THE EXECUTIVE OPTION IS NOT DISPLAYED AS A DEFAULT OPTION.");

			}

			// scroll UP the screen
			js.executeScript("window.scrollBy(0,-200)");

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	public void createEnvironmentalReport(Hashtable<String, String> data, String type, String title)
			throws InterruptedException {

		// click on the add button
		click("envreportaddbtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the add button.");

		// select the checklist from the type dropdown
		select("envreporttypedd_CSS", type);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The option is selected from the Type dropdown.");

		// enter the title
		type("envreporttitletxt_CSS", title);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The data entered in the Title field.");

		// scroll down the screen
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		// click on the date field
		click("envreportdatetxt_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the date field.");

		// click on the today button
		click("envreporttodaydate_BTNTEXT");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Today's date selected in the Date Field.");

		// click on the save report button
		click("envreportsavebtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the save Button.");

		// wait for the element
		explicitWaitClickable("closetoastmsg_CSS");

		// click on the toaster close button
		click("closetoastmsg_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the toaster close button.");

		// wait for the element
		Thread.sleep(3000);

	}

	public void createAsbestosMaterialRecord(Hashtable<String, String> data, String material, String detailed_location,
			String is_material_asbestos_containing, String asbestos_type, String condition, String status)
			throws InterruptedException {

		// click on the add button
		click("envreports_asbestosmaterials_addbtn_CSS");
		System.out.println("Clicked on the Add button.");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Navigate to the Add Asbestos Material Screen");

		// select the material
		select("envreports_asbestosmaterials_materialdd_CSS", material);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The option is selected from the Material dropdown.");

		// enter the detailed location
		type("envreports_asbestosmaterials_detailedlocationtxt_CSS", detailed_location);
		System.out.println("The data is entered in the Detailed location field.");
		ngDriver.waitForAngularRequestsToFinish();

		// scroll down the screen
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		// select the is material asbestos containing
		select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS", is_material_asbestos_containing);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The option is selected from the Material Analyzed dropdown.");

		// select the asbestos type
		select("envreports_asbestosmaterials_asbestostypedd_CSS", asbestos_type);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The option is selected from the Asbestos Type dropdown.");

		// select the condition
		select("envreports_asbestosmaterials_conditiondd_CSS", condition);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The option is selected from the Condition dropdown.");

		// select the status
		select("envreports_asbestosmaterials_statusdd_CSS", status);
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The option is selected from the Status dropdown.");

		// scroll till bottom of the page
		js.executeScript("window.scrollBy(0,400)");

		// click on the save button
		click("envreports_asbestosmaterials_savebtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("The save button clicked successfully");

		// wait for the element
		explicitWaitClickable("closetoastmsg_CSS");

		// click on the toaster close button
		click("closetoastmsg_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the toaster close button.");
	}

	public void verifyNACheckedCheckbox(String location) {
		try {
			boolean nacheckbox = driver.findElement(By.xpath(OR.getProperty(location))).isDisplayed();

			if (nacheckbox == true) {

				// click on the n/a checkbox of category 1 question 1
				click(location);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the n/a checkbox.");

				System.out.println("CLICKED ON THE NA CHECKBOX.");
				test.log(LogStatus.INFO, "CLICKED ON THE NA CHECKBOX.");
				Reporter.log("CLICKED ON THE NA CHECKBOX.");
				log.info("CLICKED ON THE NA CHECKBOX.");

			} else {
				System.out.println("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
				test.log(LogStatus.INFO, "THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
				Reporter.log("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
				log.info("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
			}
		} catch (Throwable t) {
			System.out.println("THE NA CHECKBOX ALREADY DISPLAYED SELECTED.");
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
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the n/a checkbox to uncheck." + location);

				System.out.println("CLICKED ON THE NA CHECKBOX.");
				test.log(LogStatus.INFO, "CLICKED ON THE NA CHECKBOX.");
				Reporter.log("CLICKED ON THE NA CHECKBOX.");
				log.info("CLICKED ON THE NA CHECKBOX.");

			} else {
				System.out.println("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
				test.log(LogStatus.INFO, "THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
				Reporter.log("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
				log.info("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
			}
		} catch (Throwable t) {
			System.out.println("THE NA CHECKBOX ALREADY DISPLAYED UNSELECTED.");
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

		System.out.println("********** LOGIN WITH VALID CREDENTIALS **********");
		log.info("********** LOGIN WITH VALID CREDENTIALS **********");
		Reporter.log("********** LOGIN WITH VALID CREDENTIALS **********");
		test.log(LogStatus.INFO, "********** LOGIN WITH VALID CREDENTIALS **********");

		try {

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("username_MODEL", data.get(username));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("password_MODEL", data.get(password));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Click on the Sign In button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Sign In button.");

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
			System.out.println("AN EXEPTIONS ARE OCCURED IN THIS USER, SO LOGOUT FROM THIS USER.");
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
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// LOGIN WITH ADMIN USER

			System.out.println("********** LOGIN WITH ADMIN USER **********");
			test.log(LogStatus.INFO, "********** LOGIN WITH ADMIN USER **********");
			Reporter.log("********** LOGIN WITH ADMIN USER **********");
			log.info("********** LOGIN WITH ADMIN USER **********");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

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

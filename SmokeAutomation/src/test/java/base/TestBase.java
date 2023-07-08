package base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	public static JavascriptExecutor jsDriver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	@BeforeSuite
	public void setUp() {

		// Initialize the Config and OR Properties file

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config file is loaded successfully!!!");
				System.out.println("Config file is loaded successfully!!!");
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("OR file is loaded successfully!!!");
				System.out.println("OR file is loaded successfully!!!");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		// Initialize the browsers

		if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver.exe");

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			jsDriver = (JavascriptExecutor) driver;
			ngDriver = new NgWebDriver(jsDriver);
			log.info("FireFox launched successfully!!!");
			System.out.println("FireFox launched successfully!!!");

		} else if (config.getProperty("browser").equals("chrome")) {

//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			jsDriver = (JavascriptExecutor) driver;
//			ngDriver = new NgWebDriver(jsDriver);

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			jsDriver = (JavascriptExecutor) driver;
			ngDriver = new NgWebDriver(jsDriver);
			log.info("Chrome launched successfully!!!");
			System.out.println("Chrome launched successfully!!!");
		}

		// Initialize the Application URL

		driver.get(config.getProperty("testsiteurl"));
		ngDriver.waitForAngularRequestsToFinish();
		log.info("Test site launched successfully!!!" + config.getProperty("testsiteurl"));
		System.out.println("Test site launched successfully!!! " + config.getProperty("testsiteurl"));

//		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs2.get(1));

		driver.manage().window().maximize();
		log.info("The window maximize successfully!!!");
		System.out.println("The window maximize successfully!!!");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implecit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 45);

	}

	// For click on the particular element

	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_MODEL")) {
			driver.findElement(ByAngular.model(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_BTNTEXT")) {
			driver.findElement(ByAngular.buttonText(OR.getProperty(locator))).click();
		}

		test.log(LogStatus.INFO, "Clicking on : " + locator);
		System.out.println("Clicking on : " + locator);
	}

	// For typing the text into the text field

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_MODEL")) {
			driver.findElement(ByAngular.model(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_BTNTEXT")) {
			driver.findElement(ByAngular.buttonText(OR.getProperty(locator))).sendKeys(value);
		}
		test.log(LogStatus.INFO, "Typing on : " + locator + " and entered value as " + "\"" + value + "\"");
		System.out.println("Typing on : " + locator + " and entered value as " + "\"" + value + "\"");
	}

	// Select value from the dropdown

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		} else if (locator.endsWith("_MODEL")) {
			driver.findElement(ByAngular.model(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_BTNTEXT")) {
			driver.findElement(ByAngular.buttonText(OR.getProperty(locator))).sendKeys(value);
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + "\"" + value + "\"");
		System.out.println("Selecting from dropdown : " + locator + " value as " + "\"" + value + "\"");

	}

	// Select random value from the dropdown

	static WebElement dropdownRandom;

	public void selectRandom(String locator) {

		if (locator.endsWith("_CSS")) {
			dropdownRandom = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdownRandom = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdownRandom = driver.findElement(By.id(OR.getProperty(locator)));
		}

		// Using Select Class to fetch the count
		Select select = new Select(dropdownRandom);
		List<WebElement> weblist = select.getOptions();

		// Taking the count of items
		int iCnt = weblist.size();

		// Using Random class to generate random values
		Random num = new Random();
		int iSelect = num.nextInt(iCnt);

		// Selecting value from DropDownList
		select.selectByIndex(iSelect);

		// Selected Value
		String finalValue = dropdownRandom.getAttribute("value");
		System.out.println(finalValue);

		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + "\"" + finalValue + "\"");
		System.out.println("Selecting from dropdown : " + locator + " value as " + "\"" + finalValue + "\"");

	}

	// For clear the text in the field

	public void clear(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
			ngDriver.waitForAngularRequestsToFinish();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).clear();
			ngDriver.waitForAngularRequestsToFinish();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).clear();
			ngDriver.waitForAngularRequestsToFinish();
		} else if (locator.endsWith("_MODEL")) {
			driver.findElement(ByAngular.model(OR.getProperty(locator))).clear();
			ngDriver.waitForAngularRequestsToFinish();
		} else if (locator.endsWith("_BTNTEXT")) {
			driver.findElement(ByAngular.buttonText(OR.getProperty(locator))).clear();
			ngDriver.waitForAngularRequestsToFinish();
		}

		Reporter.log("Clear the data of : " + locator);
		log.info("Clear the data of : " + locator);
		test.log(LogStatus.INFO, "Clear the data of : " + locator);
		System.out.println("Clear the data of : " + locator);
	}

	// For Explicit Wait - visibilityOfElementLocated

	public void explicitWait(String locator) {

		WebDriverWait wait = new WebDriverWait(driver, 45);
		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty(locator))));
		} else if (locator.endsWith("_BTNTEXT")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ByAngular.buttonText(OR.getProperty(locator))));
		}
		test.log(LogStatus.INFO, "Waiting for : " + locator);
		System.out.println("Waiting for : " + locator);
	}

	// For Explicit Wait - elementToBeClickable

	public void explicitWaitClickable(String locator) throws InterruptedException {

		WebDriverWait wait1 = new WebDriverWait(driver, 45);
		if (locator.endsWith("_CSS")) {
			wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			wait1.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(locator))));
		} else if (locator.endsWith("_BTNTEXT")) {
			wait1.until(ExpectedConditions.elementToBeClickable(ByAngular.buttonText(OR.getProperty(locator))));
		}

		test.log(LogStatus.INFO, "Waiting for : " + locator);
		System.out.println("Waiting for : " + locator);

	}

	// Verify the element is present or not on the screen

	public static boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	// Verify the actual result with expected result. -- Soft Assertion

	public static void verifyEquals(String locator, String expected) throws IOException {

		try {
			if (locator.endsWith("_CSS")) {
				String msg = (driver.findElement(By.cssSelector(OR.getProperty(locator))).getText()).trim();
				Assert.assertEquals(msg, expected);
			} else if (locator.endsWith("_XPATH")) {
				String msg = (driver.findElement(By.xpath(OR.getProperty(locator))).getText()).trim();
				Assert.assertEquals(msg, expected);
			} else if (locator.endsWith("_ID")) {
				String msg = (driver.findElement(By.id(OR.getProperty(locator))).getText()).trim();
				Assert.assertEquals(msg, expected);
			} else if (locator.endsWith("_MODEL")) {
				String msg = (driver.findElement(ByAngular.model(OR.getProperty(locator))).getText()).trim();
				Assert.assertEquals(msg, expected);
			} else if (locator.endsWith("_BTNTEXT")) {
				String msg = (driver.findElement(ByAngular.buttonText(OR.getProperty(locator))).getText()).trim();
				Assert.assertEquals(msg, expected);
			}
			test.log(LogStatus.INFO, "Verifing : " + locator + " value as " + "\"" + expected + "\"");
			System.out.println("Verifing : " + locator + " value as " + "\"" + expected + "\"");

		} catch (Throwable t) {

			TestUtil.captureScreenshot();

			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		}

	}

	// Verify the test is pass or not using AssertTrue

	public static void verifyTrue(String locator, String description) throws IOException {

		try {
			if (locator.endsWith("_CSS")) {
				Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty(locator))), description);
			} else if (locator.endsWith("_XPATH")) {
				Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty(locator))), description);
			} else if (locator.endsWith("_ID")) {
				Assert.assertTrue(isElementPresent(By.id(OR.getProperty(locator))), description);
			} else if (locator.endsWith("_MODEL")) {
				Assert.assertTrue(isElementPresent(ByAngular.model(OR.getProperty(locator))), description);
			} else if (locator.endsWith("_BTNTEXT")) {
				Assert.assertTrue(isElementPresent(ByAngular.buttonText(OR.getProperty(locator))), description);
			}
			System.out.println("The verified of the " + locator + " is done successfully.");
			test.log(LogStatus.INFO, "The verified of the " + locator + " is done successfully.");
			Reporter.log("The verified of the " + locator + " is done successfully.");
			log.info("The verified of the " + locator + " is done successfully.");

		} catch (Throwable t) {

			TestUtil.captureScreenshot();

			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		}

	}

	// Verification of the data using AssertTrue

	public void switchVerification(String locator, String name, String description)
			throws IOException, InterruptedException {

		try {
			if (locator.endsWith("_CSS")) {
				String str1 = (driver.findElement(By.cssSelector(OR.getProperty(locator))).getText()).trim();

				ngDriver.waitForAngularRequestsToFinish();
				if (str1.equals(name)) {
					Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty(locator))), description);

					System.out.println("The " + name + " is verified successfully.");
					test.log(LogStatus.INFO, "The " + name + " is verified successfully.");
					Reporter.log("The " + name + " is verified successfully.");
					log.info("The " + name + " is verified successfully.");
				} else {
					verificationFailed();
				}

			} else if (locator.endsWith("_XPATH")) {
				String str2 = (driver.findElement(By.xpath(OR.getProperty(locator))).getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals(name)) {
					Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty(locator))), description);

					System.out.println("The " + name + " is verified successfully.");
					test.log(LogStatus.INFO, "The " + name + " is verified successfully.");
					Reporter.log("The " + name + " is verified successfully.");
					log.info("The " + name + " is verified successfully.");
				} else {
					verificationFailed();
				}
			}

		} catch (Throwable t) {

			verificationFailed();
		}
	}

	// Scroll down to 2000 px
	public static void scrollDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

	}

	// Scroll up to top
	public static void scrollTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void randomText() throws InterruptedException, IOException {

		try {
			// enter the random string in the questionnaire title field: clear, generate
			// string, enter
			clear("questionnaire_questionnairetitletxt_CSS");
			System.out.println("Cleared the random string in the questionnaire title field.");
			ngDriver.waitForAngularRequestsToFinish();

			String s = RandomStringUtils.randomAlphabetic(8);

			type("questionnaire_questionnairetitletxt_CSS", s);
			System.out.println("Entered the random text in the questionnaire title field.");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", s);
			System.out.println("Entered newly updated questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

//		// validate random questionnaire name is displayed or not
//		switchVerification("//td[text()='"+ s +"']", s, "The " + s + " is not displayed.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void configureQuestions(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");
			System.out.println("Clicked on the configure questions option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_1_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// ADD CATEGORY 2 INTO THE QUESTIONNAIRE

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_2_XPATH", "Test Category Title Two Two",
					"The Test Category Title Two Two is not displayed.");

			// ADD QUESTIONS INTO THE CATEGORY

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");
			System.out.println("Clicked on the edit button of category one");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");
			System.out.println("Clicked on the edit question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_1"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_1"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			switchVerification("questionnaire_newquestion_1_XPATH", "Test Question Title One",
					"The Test Question Title One question is not displayed.");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question two created or not
			switchVerification("questionnaire_newquestion_2_XPATH", "Test Question Title Two Two",
					"The Test Question Title Two Two question is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button to save the question.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the Comments and Instructions field
			WebElement element = driver.findElement(
					By.cssSelector(OR.getProperty("questionnaire_question_1_commentandinstructiontxt_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));
			System.out.println("The data entered in the Comments and Instructions field.");

			// click on the option button
			click("questionnaire_question_1_optionbtn_CSS");
			System.out.println("Clicked on the option button.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD OPTION ONE IN THE QUESTION

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("questionnaire_question_1_newoption_1_titletext_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_option_1_question_1"));
			System.out.println("The title is entered successfully for create new option 1 of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// select data in type of the option of the question 1
			type("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_option_1_question_1"));
			System.out.println("The type is entered successfully for create new option 1 of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option_1_question_1"));
			System.out.println("The extra is entered successfully for create new option 1 of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");
			System.out.println("Clicked on the back to questions button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");
			System.out.println("Clicked on the back to categories button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");
			System.out.println("Clicked on the back to questionnaires button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void configureQuestionsAutoTask(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			// scroll till the more button
			WebElement element1 = driver
					.findElement(By.cssSelector(OR.getProperty("questionnaire_type_propertybtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element1);

			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");
			System.out.println("Clicked on the configure questions option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_1_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// ADD CATEGORY 2 INTO THE QUESTIONNAIRE

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_2_XPATH", "Test Category Title Two Two",
					"The Test Category Title Two Two is not displayed.");

			// ADD QUESTION 1 INTO THE CATEGORY 1

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");
			System.out.println("Clicked on the edit button of category one");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");
			System.out.println("Clicked on the edit question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_1"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_1"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			switchVerification("questionnaire_newquestion_1_XPATH", "Test Question Title One",
					"The Test Question Title One is not displayed.");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			switchVerification("questionnaire_newquestion_2_XPATH", "Test Question Title Two Two",
					"The Test Question Title Two Two is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button to save the question.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// CREATE THE AUTO GENERATE TASK

			// click on the task icon of the no option
			click("questionnaire_question_1_notaskicon_CSS");
			System.out.println("Clicked on the task icon of the no option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the non-compliant checkbox
			click("questionnaire_createtask_noncompliantbtn_CSS");
			System.out.println("Clicked on the non-compliant checkbox.");

			// click on the create a task checkbox
			click("questionnaire_createtask_createataskbtn_CSS");
			System.out.println("Clicked on the create a task checkbox.");

			// enter data in the task title field
			type("questionnaire_createtask_tasktitletxt_CSS", data.get("task_title"));
			System.out.println("The data entered in the task title field.");

			// enter data in the due date field
			type("questionnaire_createtask_duedatetxt_CSS", "30");
			System.out.println("The data entered in the due date field.");

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the find user field
			js.executeScript("window.scrollBy(0,400)");

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the allow task edit checkbox
			click("questionnaire_createtask_allowtaskeditbtn_CSS");
			System.out.println("Clicked on the allow task edit checkbox.");

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");
			System.out.println("Click on the task tag field.");
			ngDriver.waitForAngularRequestsToFinish();

			// Enter data in the find task field
			type("questionnaire_createtask_findtasktagtxt_CSS", data.get("task_find_task"));
			System.out.println("The data entered in the find task field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("questionnaire_createtask_selecttasktagtxt_XPATH");
			System.out.println("The task is selected from the list of task");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");
			System.out.println("Click on the task tag field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_createtask_savebtn_CSS");
			System.out.println("Clicked on the save button for save the details of the task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");
			System.out.println("Clicked on the back to categories button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");
			System.out.println("Clicked on the back to questionnaires button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void configureQuestionAutoTaskDependancy(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		try {
			// scroll till the more button
			WebElement element1 = driver
					.findElement(By.cssSelector(OR.getProperty("questionnaire_type_propertybtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element1);

			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");
			System.out.println("Clicked on the configure questions option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			verifyTrue("questionnaire_newcategory_1_XPATH",
					"The newly created category is not displayed in the category list.");
			System.out.println("The newly created category is displayed successfully.");
			test.log(LogStatus.INFO, "The newly created category is displayed successfully.");

			// ADD CATEGORY 2 INTO THE QUESTIONNAIRE

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			verifyTrue("questionnaire_newcategory_2_XPATH",
					"The newly created category is not displayed in the category list.");
			System.out.println("The newly created category is displayed successfully.");
			test.log(LogStatus.INFO, "The newly created category is displayed successfully.");

			// ADD QUESTIONS INTO THE CATEGORY

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");
			System.out.println("Clicked on the edit button of category one");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");
			System.out.println("Clicked on the edit question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_1"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_1"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			verifyTrue("questionnaire_newquestion_1_XPATH", "The question is not created.");
			System.out.println("The new question created successfully.");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			verifyTrue("questionnaire_newquestion_2_XPATH", "The question is not created.");
			System.out.println("The new question created successfully.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button to save the question.");
			ngDriver.waitForAngularRequestsToFinish();

			// CREATE THE AUTO GENERATE TASK

			// click on the edit question 2 button
			click("questionnaire_question_2_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task icon of the no option
			click("questionnaire_question_2_notaskicon_CSS");
			System.out.println("Clicked on the task icon of the no option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the non-compliant checkbox
			click("questionnaire_createtask_noncompliantbtn_CSS");
			System.out.println("Clicked on the non-compliant checkbox.");

			// click on the create a task checkbox
			click("questionnaire_createtask_createataskbtn_CSS");
			System.out.println("Clicked on the create a task checkbox.");

			// enter data in the task title field
			type("questionnaire_createtask_tasktitletxt_CSS", data.get("task_title"));
			System.out.println("The data entered in the task title field.");

			// enter data in the due date field
			type("questionnaire_createtask_duedatetxt_CSS", "30");
			System.out.println("The data entered in the due date field.");

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the find user field
			WebElement element3 = driver
					.findElement(By.cssSelector(OR.getProperty("questionnaire_createtask_savebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element3);

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the allow task edit checkbox
			click("questionnaire_createtask_allowtaskeditbtn_CSS");
			System.out.println("Clicked on the allow task edit checkbox.");

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");
			System.out.println("Click on the task tag field.");
			ngDriver.waitForAngularRequestsToFinish();

			// Enter data in the find task field
			type("questionnaire_createtask_findtasktagtxt_CSS", data.get("task_find_task"));
			System.out.println("The data entered in the find task field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("questionnaire_createtask_selecttasktagtxt_XPATH");
			System.out.println("The task is selected from the list of task");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");
			System.out.println("Click on the task tag field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_createtask_savebtn_CSS");
			System.out.println("Clicked on the save button for save the details of the task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the edit button of the question 2
			click("questionnaire_question_2_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the comment field
			WebElement element6 = driver.findElement(
					By.cssSelector(OR.getProperty("questionnaire_question_1_commentandinstructiontxt_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element6);

			// click on the dependency button of the question 2
			click("questionnaire_question_2_dependencybtn_CSS");
			System.out.println("Clicked on the dependency button of the question 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add icon of the depends on question
			click("questionnaire_question_dependancies_addbtn1_CSS");
			System.out.println("Clicked on the add icon of the depends on question.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the filter field of the dependency
			type("questionnaire_question_dependancies_filter_CSS", data.get("question_title_1"));
			System.out.println("Entered the data in the filter field of the dependency.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the filtered result
			click("questionnaire_question_dependancies_filteredresult_CSS");
			System.out.println("Clicked on the filtered result.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the yes option from the dropdown
			select("questionnaire_yesselect_CSS", data.get("dependency_dd"));
			System.out.println("Selected the yes option from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_question_dependancies_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");
			System.out.println("Clicked on the back to questions button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all the question
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button for save all the question.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");
			System.out.println("Clicked on the back to categories button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");
			System.out.println("Clicked on the back to questionnaires button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void createSurveyQuestionnaire(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("questionnaire_title"));
			System.out.println("The data entered in the Questionnaire Title field.");

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

//		// select the document/report type
//		select("questionnaire_docreportdd_CSS", data.get("document_reporttype"));
//		System.out.println("The data entered in the document/report type field.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// select the default task tag
//		select("questionnaire_defaulttasktagdd_CSS", data.get("default_task_tag"));
//		System.out.println("The data entered in the default task tag field.");
//		ngDriver.waitForAngularRequestsToFinish();

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			System.out.println("The data entered in the frequency field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");
			System.out.println("The data entered in the year field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void createChecklistQuestionnaire(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
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
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered the questionnaire title in the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

//		// select the document/report type
//		select("questionnaire_docreportdd_CSS", data.get("document_reporttype"));
//		System.out.println("The data entered in the document/report type field.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// select the default task tag
//		select("questionnaire_defaulttasktagdd_CSS", data.get("default_task_tag"));
//		System.out.println("The data entered in the default task tag field.");
//		ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");
			System.out.println("Clicked on the warranty checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	public void deleteSurveyQuestionnaire(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");
			System.out.println("Clicked on the configure questions option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");
			System.out.println("Clicked on the edit button of category one");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");
			System.out.println("Clicked on the edit question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the question 1
			click("questionnaire_question_1_deletebtn_CSS");
			System.out.println("Clicked on the delete button of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_question_1_deletebtn_CSS");

			// click on the delete button of the question 2
			click("questionnaire_question_1_deletebtn_CSS");
			System.out.println("Clicked on the delete button of the question 2");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button to save the question.");
			ngDriver.waitForAngularRequestsToFinish();

//		// click on the delete button of the confirmation pop up model i.e. Answer found
//		click("questionnaire_deletequestions_CSS");
//		System.out.println("Clicked on the delete button of the confirmation pop up model i.e. Answer found model.");
//		ngDriver.waitForAngularRequestsToFinish();

//		// click on the save button of the questions
//		click("questionnaire_saveallquestionbtn_CSS");
//		System.out.println("Clicked on the save button to save the question.");
//		ngDriver.waitForAngularRequestsToFinish();

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");
			System.out.println("Clicked on the back to categories button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the category 1
			click("questionnaire_category_1_deletebtn_CSS");
			System.out.println("Clicked on the delete button of the category 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_category_1_deletebtn_CSS");

			// click on the delete button of the category 2
			click("questionnaire_category_1_deletebtn_CSS");
			System.out.println("Clicked on the delete button of the category 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");
			System.out.println("Clicked on the back to questionnaires button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void questionnaireNotDisplay() throws IOException {
		System.out.println("The newly created questionnaire is not displayed.");
		test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
		Reporter.log("The newly created questionnaire is not displayed.");
		log.info("The newly created questionnaire is not displayed.");

		TestUtil.captureScreenshot();

		// ReportNG
		Reporter.log("<br>" + "The newly created questionnaire is not displayed : " + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");

		// Extent Report
		test.log(LogStatus.FAIL, " The newly created questionnaire is not displayed : ");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
	}

	public void taskNotDisplay() throws IOException {
		System.out.println("The auto generated task is not displayed.");
		test.log(LogStatus.INFO, "The auto generated task is not displayed.");
		Reporter.log("The auto generated task is not displayed.");
		log.info("The auto generated task is not displayed.");

		TestUtil.captureScreenshot();

		// ReportNG
		Reporter.log("<br>" + "The auto generated task is not displayed : " + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");

		// Extent Report
		test.log(LogStatus.FAIL, " The auto generated task is not displayed : ");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

	}

	public void verificationFailed() throws IOException, InterruptedException {

		TestUtil.captureScreenshot();

		// ReportNG
		Reporter.log("<br>" + " The verification is failed : " + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");

		// Extent Report
		test.log(LogStatus.FAIL, " The verification is failed : ");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		System.out.println("The verification is failed.");
		log.info("The verification is failed.");

	}

	public void verificationFailedMessage(String message) throws IOException, InterruptedException {

		TestUtil.captureScreenshot();

		// ReportNG
		Reporter.log("<br>" + message + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");

		// Extent Report
		test.log(LogStatus.FAIL, message);
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		System.out.println(message);
		log.info(message);

	}

	public void switchSystemCompany(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_sidemenubtn_CSS");

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The company 1 is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	// This method will set any parameter string to the system's clipboard.

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			// Setting clip board with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public void addPermissionTwoUsersRole(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_le_filtertxt_CSS", data.get(search));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click(locator);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("propertyproject_securitysettings1_searchedcontractor_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the user in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the user in search field.");

			// click on the searched result
			click("propertyproject_securitysettings1_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// enter the name of the user in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user1_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the user in search field.");

			// click on the searched result
			click("propertyproject_securitysettings1_searchedhr1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void addPermissionOneUsersRoleTask(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_le_filtertxt_CSS", data.get(search));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click(locator);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("task_permission_securitysettings_seachedrole_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the user in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the user in search field.");

			// click on the searched result
			click("task_permission_securitysettings_seacheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void addPermissionOneUsersRole(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_le_filtertxt_CSS", data.get(search));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click(locator);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("propertyproject_securitysettings1_searchedcontractor_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the user in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the user in search field.");

			// click on the searched result
			click("propertyproject_securitysettings1_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void resetPermission(Hashtable<String, String> data, String search, String locator)
			throws InterruptedException, IOException {

		try {
			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_le_filtertxt_CSS", data.get(search));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click(locator);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void deleteVerification(String locator, String expectedResult) {
		try {

			String deleteElement = (driver.findElement(By.xpath(OR.getProperty(locator))).getText()).trim();

			if (deleteElement.equals(expectedResult)) {

				Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty(locator))),
						"The " + expectedResult + " is displayed.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The  " + expectedResult + " is not deleted : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The " + expectedResult + " is not deleted : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The " + expectedResult + " is not deleted.");
				log.info("The " + expectedResult + " is not deleted.");

			}
		} catch (Throwable t) {
			System.out.println("The " + expectedResult + " is deleted successfully.");
			test.log(LogStatus.INFO, "The " + expectedResult + " is deleted successfully.");
			Reporter.log("The " + expectedResult + " is deleted successfully.");
			log.info("The " + expectedResult + " is deleted successfully.");
		}

	}

	public void selectRoleForSecuritySetting(Hashtable<String, String> data, String permissionName,
			String searchedPermissionName, String roleName, String seachedRoleName)
			throws InterruptedException, IOException {

		try {
			// search the Access to PO section in tasks
			clear("envreports_propertylist_filtertxt_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("envreports_propertylist_filtertxt_CSS", data.get(permissionName));
			System.out.println("Searched the Access to PO section in tasks.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched security setting
			click(searchedPermissionName);
			System.out.println("Clicked on the searched security setting.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the role field
			click("securitysettings_rolenametxt_CSS");
			System.out.println("Clicked on the role field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("riskmanagement_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get(roleName));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched role
			click(seachedRoleName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched role.");

			// click on the role field
			click("securitysettings_rolenametxt_CSS");
			System.out.println("Clicked on the role field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");
			System.out.println("Clicked on the user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("riskmanagement_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");
			System.out.println("Clicked on the user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	public void selectUserForSecuritySetting(Hashtable<String, String> data, String permissionName,
			String searchedPermissionName, String userName, String seachedUserName)
			throws InterruptedException, IOException {

		try {
			// search the permission in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("envreports_propertylist_filtertxt_CSS", data.get(permissionName));
			System.out.println("Searched the permission in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched security setting
			click(searchedPermissionName);
			System.out.println("Clicked on the searched security setting.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the role field
			click("securitysettings_rolenametxt_CSS");
			System.out.println("Clicked on the role field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("riskmanagement_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the role field
			click("securitysettings_rolenametxt_CSS");
			System.out.println("Clicked on the role field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");
			System.out.println("Clicked on the user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("riskmanagement_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user in the search field
			type("task_tasktag_searchtxt_CSS", data.get(userName));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user in the search field.");

			// click on the searched role
			click(seachedUserName);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched role.");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");
			System.out.println("Clicked on the user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}
	}

	// UPDATE THE SYSTEM COMPANY

	public void updateCompany(Hashtable<String, String> data) throws IOException, InterruptedException {

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_sidemenubtn_CSS");

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the system company from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The system company is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

	}

	// get the number of entries in the table

	public int getNumberOfEntries() {

		String entriesTxt = driver.findElement(By.id("example_info")).getText().trim();
		String[] aEntriesText = entriesTxt.split(" ");
		String totalEntriesText = aEntriesText[aEntriesText.length - 2];
		return Integer.parseInt(totalEntriesText);
	}

	// get the latest file from the directory

	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	// returns the row count in a sheet

	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

	// returns number of columns in a sheet

	public int getColumnCount(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	public void successMessage(String message) {
		System.out.println(message);
		test.log(LogStatus.INFO, message);
		Reporter.log(message);
		log.info(message);
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		log.info("Test execution completed!!!");
		System.out.println("Test execution completed!!!");
	}

}

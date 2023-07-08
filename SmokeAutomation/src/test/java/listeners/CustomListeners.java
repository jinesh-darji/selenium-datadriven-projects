package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.MonitoringMail;
import utilities.TestConfig;
import utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	public String messageBody;
	
	// public String messageBody;

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult arg0) {

		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">ScreenShot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult arg0) {

		test.log(LogStatus.SKIP, arg0.getName().toUpperCase() + " Skipped the test as the Run Mode is NO");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext arg0) {

		test = rep.startTest(arg0.getName().toUpperCase());

	}

	public void onFinish(ITestContext context) {

	}

	public void onStart(ISuite arg0) {

	}

	public void onFinish(ISuite context) {
		MonitoringMail mail = new MonitoringMail();
		
//		try {
//			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//					+ ":8080/job/Refined_Risk_UIAutomation/Extent_20Reports/";
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		messageBody = "<p>Hello All,</p>\r\n"
				+ "<p><br></p>\r\n"
				+ "<p>Please refer to below URL for the automation report of the Smoke Test Cases:</p>\r\n"
				+ "<p><br></p>\r\n"
				+ "<p>https://autotest.refineddata.com/job/Refined_Risk_Smoke_Automation/Extent_20Reports/</p>\r\n"
				+ "<p><br></p>\r\n"
				+ "<p>Note: Connect to Jinesh Darji on slack, For Jenkins credentials. (if not available)</p>";
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

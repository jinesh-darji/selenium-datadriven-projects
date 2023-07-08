package testcases.E2Etestcasesuite.loginmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RefinedRiskLoginTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void refinedRiskLoginTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "refinedRiskLoginTest");

		Helper helper = new Helper();
		
		helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

	}
}

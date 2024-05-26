package testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.LoginPage;
import automationFramework.TestingBasicDriverOps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login extends TestingBasicDriverOps {

	private static final Logger logger = LogManager.getLogger(Login.class);

	@Test(groups = "regression")
	@Parameters({ "username", "password" })
	public void loginWithValidCredentials(String username, String password) {
		// WebDriver driver = new ChromeDriver();
		LoginPage lPage = new LoginPage(driver);
		// lPage.login("admin", "admin123");
		lPage.login(username, password);
		boolean result = lPage.logginPassed();
		Assert.assertTrue(result);

		/*
		 * logger.debug("This is a debug message");
		 * logger.info("This is an info message");
		 * logger.warn("This is a warning message");
		 * logger.error("This is an error message");
		 * logger.fatal("This is a fatal message");
		 */

	}

	@Test(groups = "regression")
	@Parameters({ "username", "wrongPassword" })
	public void loginWithoutValidCredentials(String username, String password) {
		// WebDriver driver = new ChromeDriver();
		LoginPage lPage = new LoginPage(driver);
		lPage.login(username, password);
		boolean result = lPage.logginFailed();
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void tearDown(ITestResult result) { // Get the name of
		String methodName = result.getMethod().getMethodName();
		logger.info("Teardown method executed after method: " + methodName);
	}
}

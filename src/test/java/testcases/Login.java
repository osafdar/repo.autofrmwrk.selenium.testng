package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import automationFramework.TestingBasicDriverOps;

public class Login extends TestingBasicDriverOps {

	@Test(groups = "regression")
	@Parameters({ "username", "password" })
	public void loginWithValidCredentials(String username, String password) {
		boolean result = performLogin(username, password, driver);
		Assert.assertTrue(result);

		/*
		 * logger.debug("This is a debug message");
		 * logger.info("This is an info message");
		 * logger.warn("This is a warning message");
		 * logger.error("This is an error message");
		 * logger.fatal("This is a fatal message");
		 */

	}

	public static boolean performLogin(String username, String password, WebDriver driver) {
		LoginPage lPage = new LoginPage(driver);
		lPage.login(username, password);
		boolean result = lPage.logginPassed();
		return result;
	}

	@Test(groups = "regression")
	@Parameters({ "username", "wrongPassword" })
	public void loginWithoutValidCredentials(String username, String password) {
		LoginPage lPage = new LoginPage(driver);
		lPage.login(username, password);
		boolean result = lPage.logginFailed();
		Assert.assertTrue(result);
	}

	@BeforeMethod
	public void InstantiateLogger() {
		if (logger == null) {
			logger = LogManager.getLogger(Login.class);
		}
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) {
		// String methodName = result.getMethod().getMethodName();
		// return ("Teardown method executed after method: " + methodName);
		logger.info(this.getExecutedMethodInfo(result));
	}

}

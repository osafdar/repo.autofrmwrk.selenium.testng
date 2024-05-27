package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import automationFramework.TestingBasicDriverOps;

public class Home extends TestingBasicDriverOps {

	//private static final Logger logger = LogManager.getLogger(Home.class);

	@Test(groups = "regression")
	@Parameters({ "searchText","username","password"})
	public void searchUser(String searchText, String username, String password) {
		HomePage hPage = new HomePage(driver);
		Login.performLogin(username, password, driver);
		hPage.clickAdminLink();
		hPage.enterUserName(searchText);
		hPage.performSearch();
	}

	@BeforeMethod
	public void InstantiateLogger() {
		if(logger==null) {
			logger=LogManager.getLogger(Home.class);
		}
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result) {
		logger.info(this.getExecutedMethodInfo(result));
	}
}

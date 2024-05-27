package automationFramework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestingBasicDriverOps {
	protected WebDriver driver;
	protected Logger logger;

	@BeforeClass
	public void beforeSuite() {
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterSuite() {
		driver.quit();
	}

	
	public String getExecutedMethodInfo(ITestResult result) { // Get the name of
		String methodName = result.getMethod().getMethodName();
		return ("Teardown method executed after method: " + methodName);
	}

}

package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestingBasicDriverOps {
	protected WebDriver driver;


	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

	@AfterMethod
	public void afterMethod() {

	}

}

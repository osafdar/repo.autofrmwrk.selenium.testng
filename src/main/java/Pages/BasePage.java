package Pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Debug;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected By homePageDashboardTitle = By.className("oxd-text--h6");

	protected void waitForElement(By elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement control = wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
		} catch (Exception ex) {
			throw ex;
		}
	}

	// Get current URL
		public String getCurrentURL() {
			return driver.getCurrentUrl();
		}
	
	protected boolean IsOnHomePage() {
		waitForElement(this.homePageDashboardTitle);
		WebElement element = driver.findElement(homePageDashboardTitle);
		if (element != null && element.getText().equalsIgnoreCase("Dashboard")) {
			return true;
		} else
			return false;
	}

}

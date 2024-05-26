package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	// Web elements
	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.className("oxd-button");
	private By loginFailureIcon = By.className("bi-exclamation-circle");

	private String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForLoadToComplete() {
		waitForElement(usernameField);
	}

	// Set username
	public void setUsername(String username) {
		WebElement usernameInput = driver.findElement(usernameField);
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	// Set password
	public void setPassword(String password) {
		WebElement passwordInput = driver.findElement(passwordField);
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	// Click login button
	private void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public boolean logginPassed() {
		return IsOnHomePage();
	}

	public boolean logginFailed() {
		this.WaitForLoadToComplete();
		if(null!=driver.findElement(loginFailureIcon)){
			return true;
		}
		return false;
	}

	

	// Perform login
	public void login(String username, String password) {
		driver.navigate().to(URL);
		WaitForLoadToComplete();
		setUsername(username);
		setPassword(password);
		clickLogin();
	}

}
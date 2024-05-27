package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginSteps {

    WebDriver driver ;

    protected void waitForElement(By elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement control = wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
		} catch (Exception ex) {
			throw ex;
		}
	}
    
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Initialize the WebDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get(LoginPage.URL);
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
    	waitForElement(By.name("username"));
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("the user submits the login form")
    public void the_user_submits_the_login_form() {
        WebElement loginButton = driver.findElement(By.className("oxd-button"));
        loginButton.click();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() throws InterruptedException {
        String expectedUrl = HomePage.URL;
        String actualUrl = driver.getCurrentUrl();
        waitForElement(HomePage.adminLink);
        Assert.assertEquals(actualUrl, expectedUrl);
        //driver.quit();
    }

    /*
    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }*/
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()||true) {
            // Capture screenshot and embed it in the report
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        driver.quit();
    }
    
   
}

package automationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPage;

public class TestRunner {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement control = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("oxd-button")).click();
		*/
		//driver.quit();
		
		LoginPage lPage = new LoginPage(driver);
		lPage.login("admin", "admin123");
		
		
		
	}

}

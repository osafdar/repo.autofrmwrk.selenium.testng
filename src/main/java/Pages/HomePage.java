package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	private By adminLink = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
	public static String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	private By usernameTextbox = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	private By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserName(String text) {
		this.waitForElement(usernameTextbox);
		this.typeText(usernameTextbox, text);
	}
	
	public void performSearch() {
		this.click(searchButton);
	}

	public void clickAdminLink() {
		this.waitForElement(adminLink);
		click(adminLink);
		
	}

}

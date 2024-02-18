package ThinkTester.ContactListApp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ThinkTester.ContactListApp.Utils.Environment;

public class LoginPage extends BasePage {
	private static final By SIGNUP_BUTTON = By.id("signup");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void open() {
		driver.navigate().to(Environment.HEROKU);
		this.isLoaded();
	}

	@Override
	public void isLoaded() {
		wait.until(
				ExpectedConditions.elementToBeClickable(SIGNUP_BUTTON)
				);
	}
}

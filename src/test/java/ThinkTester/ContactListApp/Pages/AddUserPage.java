package ThinkTester.ContactListApp.Pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddUserPage extends BasePage {

	private static final By FIRSTNAME_FIELD = By.id("firstName");
	private static final By LASTNAME_FIELD = By.id("lastName");
	private static final By EMAIL_FIELD = By.id("email");
	private static final By PASSWORD_FIELD = By.id("password");

	private static final By SUBMIT_BUTTON = By.id("submit");

	public AddUserPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void assertIsLoaded() {
		wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON));
	}

	public void addNewUser(Map<String, String> user) {

		driver.findElement(FIRSTNAME_FIELD).clear();
		driver.findElement(FIRSTNAME_FIELD).sendKeys(user.get("firstName"));

		driver.findElement(LASTNAME_FIELD).clear();
		driver.findElement(LASTNAME_FIELD).sendKeys(user.get("lastName"));

		driver.findElement(EMAIL_FIELD).clear();
		driver.findElement(EMAIL_FIELD).sendKeys(user.get("email"));

		driver.findElement(PASSWORD_FIELD).clear();
		driver.findElement(PASSWORD_FIELD).sendKeys(user.get("password"));

		driver.findElement(SUBMIT_BUTTON).click();
	}

}

package ThinkTester.ContactListApp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactListPage extends BasePage {

	private static final By LOGOUT_BUTTON = By.id("logout");

	public void logout() {
		driver.findElement(LOGOUT_BUTTON).click();
	}

	public ContactListPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void assertIsLoaded() {
		wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
	}
}

package ThinkTester.ContactListApp.Tests.UiTests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ThinkTester.ContactListApp.Pages.AddUserPage;
import ThinkTester.ContactListApp.Pages.ContactListPage;
import ThinkTester.ContactListApp.Pages.LoginPage;
import ThinkTester.ContactListApp.Utils.UserFactory;

public class SmokeUiTest {
	
	private Map<String, String> user;
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		user = UserFactory.getRandomUser();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.assertIsLoaded();
	}
	
	@Test
	public void happyPathTest() {	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToAddUserPage();
		
		AddUserPage addUserPage = new AddUserPage(driver);
		addUserPage.assertIsLoaded();
		
		addUserPage.addNewUser(user);
		
		ContactListPage contactListPage = new ContactListPage(driver);
		contactListPage.assertIsLoaded();
		
		contactListPage.logout();
		loginPage.assertIsLoaded();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
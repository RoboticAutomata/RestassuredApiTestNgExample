package ThinkTester.ContactListApp.Tests.UiTests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ThinkTester.ContactListApp.Apis.UserApi;
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
		
		new LoginPage(driver).open();
	}
	
	@Test
	public void happyPathTest() {	
		//signup
		//wait
		
		//register
		//wait
		
		//login
		//wait
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
		//deleteUser();
	}
	
	private void deleteUser() {	
		String token = UserApi.loginUser(user)
				.then().assertThat().statusCode(200)
				.extract().jsonPath().get("token");

		user.put("token", token);
		
		UserApi.deleteUser(token)
			.then().assertThat().statusCode(200);
	}
}
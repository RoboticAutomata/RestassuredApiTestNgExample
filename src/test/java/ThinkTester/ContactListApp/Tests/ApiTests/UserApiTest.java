package ThinkTester.ContactListApp.Tests.ApiTests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ThinkTester.ContactListApp.Apis.UserApi;
import ThinkTester.ContactListApp.Utils.Environment;
import ThinkTester.ContactListApp.Utils.UserFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApiTest {
	
	private Map<String, String> user;
	
	@BeforeClass
	public void setup() {
		user = UserFactory.getRandomUser();
		RestAssured.baseURI = Environment.HEROKU;
	}
	
	@Test
	public void addUserTest() {	
		Response response = UserApi.addUser(user);
		
		response.then().assertThat().statusCode(201);
	}

	@Test(dependsOnMethods = "addUserTest")
	public void loginUserTest() {	
		Response response = UserApi.loginUser(user);
		
		response.then().assertThat().statusCode(200);
		
		String token = response.jsonPath().get("token");
		
		user.put("token", token);
	}
	
	@Test(dependsOnMethods = "loginUserTest")
	public void logoutUserTest() {	
		String token = user.get("token");
		Response response = UserApi.logoutUser(token);
		
		response.then().assertThat().statusCode(200);
	}
	
	@Test(priority = 1)
	public void deleteUserTest() {	
		loginUserTest();
		
		String token = user.get("token");
		Response response = UserApi.deleteUser(token);
		
		response.then().assertThat().statusCode(200);
	}		
}
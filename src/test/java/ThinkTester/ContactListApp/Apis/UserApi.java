package ThinkTester.ContactListApp.Apis;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserApi {

	private static String USERS_ENDPOINT = "users/";
	private static String LOGIN_ENDPOINT = "login/";
	private static String LOGOUT_ENDPOINT = "logout/";
	private static String DELETE_ENDPOINT = "me/";
	
	public static Response addUser(Map<String, String> requestBody) {
		return RestAssured
			.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
			.when()
				.post(USERS_ENDPOINT);
	}
	
	public static Response loginUser(Map<String, String> requestBody) {
		return RestAssured
			.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.basePath(USERS_ENDPOINT)
			.when()
				.post(LOGIN_ENDPOINT);
	}
	
	public static Response logoutUser(String token) {
		return RestAssured
			.given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.basePath(USERS_ENDPOINT)
			.when()
				.post(LOGOUT_ENDPOINT);
	}
	
	public static Response deleteUser(String token) {
		return RestAssured
			.given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.basePath(USERS_ENDPOINT)
			.when()
				.delete(DELETE_ENDPOINT);
	}
}

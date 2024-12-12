package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.userPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createUser(userPayload payload)
	{
		Response user_post_res=
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when()
			.post(Routes.user_post_url);
		
		return user_post_res;
	}
	
	
	public static Response readUser(String username)
	{
		Response user_get_res=
		given()
			.pathParam("username", username)
			
		.when()
			.get(Routes.user_get_url);
		
		return user_get_res;
	}
	
	
	public static Response updateUser(userPayload payload, String username)
	{
		Response user_update_res=
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			
		.when()
			.put(Routes.user_update_url);
		
		return user_update_res;
	}
	
	
	public static Response deleteUser(String username)
	{
		Response user_delete_res=
		given()
			.pathParam("username", username)
			
		.when()
			.delete(Routes.user_delete_url);
		
		return user_delete_res;
	}
}

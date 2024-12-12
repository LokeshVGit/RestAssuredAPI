package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.userPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	static ResourceBundle getURLs()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //Its loads all URLs form property file
		return routes;
	}

 	public static Response createUser(userPayload payload)
	{
 		String post_url = getURLs().getString("user_post_url");
 		
		Response user_post_res=
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when()
			.post(post_url);
		
		return user_post_res;
	}
	
	
	public static Response readUser(String username)
	{
		String get_url = getURLs().getString("user_get_url");
		
		Response user_get_res=
		given()
			.pathParam("username", username)
			
		.when()
			.get(get_url);
		
		return user_get_res;
	}
	
	
	public static Response updateUser(userPayload payload, String username)
	{
		String update_url = getURLs().getString("user_update_url");
		
		Response user_update_res=
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			
		.when()
			.put(update_url);
		
		return user_update_res;
	}
	
	
	public static Response deleteUser(String username)
	{
		String delete_url = getURLs().getString("user_delete_url");
		
		Response user_delete_res=
		given()
			.pathParam("username", username)
			
		.when()
			.delete(delete_url);
		
		return user_delete_res;
	}
}

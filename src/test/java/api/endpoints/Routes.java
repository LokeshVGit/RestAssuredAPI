package api.endpoints;

/*
Swagger URL - https://petstore.swagger.io/v2

Create User	- https://petstore.swagger.io/v2/user
Get	User	- https://petstore.swagger.io/v2/user/{username}
Update User	- https://petstore.swagger.io/v2/user/{username}
Delete User	- https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Model End points
	
	public static String user_post_url = base_url+"/user";
	public static String user_get_url = base_url+"/user/{username}";
	public static String user_update_url = base_url+"/user/{username}";
	public static String user_delete_url = base_url+"/user/{username}";
	
	
	//Pet Model End points
	
	
	//Store Model End points
}

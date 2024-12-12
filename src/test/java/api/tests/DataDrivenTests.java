package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.userPayload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	@Test(priority=1, dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String uName, String fName, String lName, String email, String pwd, String ph)
	{
		userPayload UPayload = new userPayload();
		
		UPayload.setId(Integer.parseInt(userID));
		UPayload.setUsername(uName);
		UPayload.setFirstname(fName);
		UPayload.setLastname(lName);
		UPayload.setEmail(email);
		UPayload.setPassword(pwd);
		UPayload.setPhone(ph);
		
		Response res1 = UserEndpoints.createUser(UPayload);
		Assert.assertEquals(res1.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testGetUserByName(String username)
	{
		Response res2 = UserEndpoints.readUser(username);
		Assert.assertEquals(res2.getStatusCode(),200);
	}
	
	@Test(priority=3, dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String username)
	{
		Response res3 = UserEndpoints.deleteUser(username);
		Assert.assertEquals(res3.getStatusCode(),200);
	}
}

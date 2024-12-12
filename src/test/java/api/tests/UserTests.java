package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.userPayload;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	userPayload UPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		faker = new Faker();
		UPayload = new userPayload();
		
		UPayload.setId(faker.idNumber().hashCode());
		UPayload.setUsername(faker.name().username());
		UPayload.setFirstname(faker.name().firstName());
		UPayload.setLastname(faker.name().lastName());
		UPayload.setEmail(faker.internet().safeEmailAddress());
		UPayload.setPassword(faker.internet().password(5,10));
		UPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//Logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("********          Creating a User          ********");
		Response res1 = UserEndpoints.createUser(UPayload);
		res1.then().log().all();
		
		Assert.assertEquals(res1.getStatusCode(), 200);
		logger.info("********          User is Created          ********");
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("********          Retrieving a User          ********");
		Response res2 = UserEndpoints.readUser(this.UPayload.getUsername());
		res2.then().log().all();
		
		Assert.assertEquals(res2.getStatusCode(), 200);
		logger.info("********          User is Retrieved          ********");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("********          Updating a User          ********");
		//Changing the data by re-generating the payload data 
		
		UPayload.setFirstname(faker.name().firstName());
		UPayload.setLastname(faker.name().lastName());
		UPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res3 = UserEndpoints.updateUser(UPayload, this.UPayload.getUsername());
		res3.then().log().all();
		
		Assert.assertEquals(res3.getStatusCode(), 200);
		
		//Checking the data after updating
		Response resAfterUpdate = UserEndpoints.readUser(this.UPayload.getUsername());
		resAfterUpdate.then().log().all();
		
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
		logger.info("********          User is Updated          ********");
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("********          Deleting a User          ********");	
		Response res4 = UserEndpoints.deleteUser(this.UPayload.getUsername());
		
		Assert.assertEquals(res4.getStatusCode(), 200);
		logger.info("********          User is Deleted          ********");
	}
}

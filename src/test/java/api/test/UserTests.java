package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests
{
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	//this metod would be exectued before starting of all the test methods. 
	public void setupData()
	{
		//generate the data. pass to the POJO class, along with POST request. 
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}	
	
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	//write test cases for each varibales. 
	@Test(priority = 2)
	public void testGetUserByName() 
	{
		Response response = UserEndPoints.ReadUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUserbyName() 
	{
		//update payload data using 
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		//regenerate the same details. updated data. 
		
		Response response = UserEndPoints.UpdateUser(this.userPayload.getUsername() , userPayload);
		response.then().log().all(); //REST asseration . 
		
		Assert.assertEquals(response.getStatusCode(), 200); //TestNG asseration. 
		
		//checking data after update
		Response responseafterupdate = UserEndPoints.ReadUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

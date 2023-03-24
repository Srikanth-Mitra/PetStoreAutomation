package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class PetTests 
{
	Faker faker;
	Pet petPayload;
	
	@BeforeClass
	public void setupData()
	{
		//generate fake data
		faker = new Faker();
		petPayload = new Pet();
		
		petPayload.setId(faker.number().randomDigitNotZero());
		petPayload.setPetId(faker.number().randomDigitNotZero());
		petPayload.setQuantity(faker.number().numberBetween(1,20));
		petPayload.setShipDate(faker.date().birthday().toInstant().toString());
		//System.out.println(petPayload.setShipDate(faker.date().birthday().toInstant().toString()));
		petPayload.setStatus("placed");
		petPayload.setComplete(faker.bool().bool());
		
	}
	
	@Test(priority=1)
	public void testPostPet()
	{
		Response response = PetEndPoints.OrderPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}

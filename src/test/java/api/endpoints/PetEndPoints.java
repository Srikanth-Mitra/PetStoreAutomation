package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints 
{
	public static Response OrderPet(Pet payload)
	{
		Response response=given()
				//headres also needs to be added in this place
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_store_url);
		
		return response;
	}
	
	public static Response findPurchase(int orderid)
	{
		Response response=given()
				.pathParam("orderid", orderid)
			.when()
				.get(Routes.getpurchase_store_url);
		
		return response;	
	}
	
}

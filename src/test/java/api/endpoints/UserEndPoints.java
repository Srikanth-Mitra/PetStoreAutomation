package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//having only CURD operations. creeate , retrive , update and delete. 

//userendpoints.java , Payload is request body

public class UserEndPoints 
{
	
	public static Response createUser(User payload)
	{
		Response response=given()
			//headres also needs to be added in this place
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);	//url from the route class. Thats why we need route class
		
		return response;
	}
	
	//reading 
	public static Response ReadUser(String username)
	{
		Response response=given()
			//headres also needs to be added in this place
			.pathParam("username", username)
		.when()
			.get(Routes.get_url);	//url from the route class. Thats why we need route class
		
		return response;
	}
	
	//update user
	public static Response UpdateUser(String userName,User payload)
	{
		Response response=given()
			//headres also needs to be added in this place
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",userName)
			.body(payload)
		.when()
			.put(Routes.update_url);	//url from the route class. Thats why we need route class
		
		return response;
	}
	
	//delete Request 
	public static Response DeleteUser(String username)
	{
		Response response=given()
			//headres also needs to be added in this place
			.pathParam("username", username)
		.when()
			.delete(Routes.delete_url);	//url from the route class. Thats why we need route class
		
		return response;
	}
}

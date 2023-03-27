package api.endpoints;


/*Swagger Endponits
 *
 *Basic Endpoint : https://petstore.swagger.io/v2
 *
 * Create User (Post): https://petstore.swagger.io/v2/user
 * Get User (Get) : https://petstore.swagger.io/v2/user/{username}
 * Update User (put) : https://petstore.swagger.io/v2/user/{username}
 * Delete User : (delete) : https://petstore.swagger.io/v2/user/{username}
 * 
 * 
 *
 */
public class Routes 
{
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module creating the routes
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//store module
	public static String post_store_url = base_url+"/store/order";
	public static String getpurchase_store_url = base_url+"/store/order/{petId}";
	public static String delete_store_url = base_url+"/store/order/{petId}";
	public static String get_store_url = base_url+"/store/inventory";
}

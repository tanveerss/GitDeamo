

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import PayloadFiles.PostAPIPayloads;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostPlace {

	public static void main(String[] args) {
	
		//post API

		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Response response = given().log().all().header("Content-Type","application/json").queryParam("key", "qaclick123")
		.body(PostAPIPayloads.addPlace()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).
		body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response();
	    System.out.println("Finding Headers");	
		java.util.List<Header> Headers = response.getHeaders().asList();
		
		for(int i=0;i<Headers.size();i++)
		{
			
			System.out.println(Headers.get(i));
		}
	System.out.println("Finding Place ID ");
		
		String res = response.asString();
		JsonPath jp = new JsonPath(res);//JsonPath required string type argument
		String place_id  = jp.getString("place_id");
		System.out.println("place_id is : "+place_id);
		
		// Update Place
		
		given().log().all().header("Content-Type","application/json").queryParam("key", "qaclick123").
		body("{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\":\"70 Summer walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

	}

}

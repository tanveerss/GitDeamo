

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import PayloadFiles.PostAPIPayloads;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostPlaceWithJSONFile {
	
	public static void main(String[] args) throws IOException {
		
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	Response response = given().log().all().header("Content-Type","application/json").queryParam("key", "qaclick123")
	.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\IBMADMIN\\Desktop\\PostAPIPayload.json")))).
	when().post("/maps/api/place/add/json").
	then().log().all().assertThat().statusCode(200).
	body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response();
System.out.println("Finding Headers");	

	}
}

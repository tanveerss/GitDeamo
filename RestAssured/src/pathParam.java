

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import PayloadFiles.PostAPIPayloads;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class pathParam {

	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Response response = given().log().all().pathParam("book", "java").header("Content-Type","application/json").queryParam("key", "qaclick123")
		.body(PostAPIPayloads.addPlace()).when().post("/maps/api/{book}/add/json").then().log().all().assertThat().statusCode(200).
		body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response();
	}

}
